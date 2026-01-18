package com.example.bookmyshow.service;

import com.example.bookmyshow.dto.BookRequest;
import com.example.bookmyshow.entity.*;
import com.example.bookmyshow.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import java.time.LocalDateTime;

@Service
public class BookingService {
    private final ShowRepository showRepo;
    private final ShowSeatRepository showSeatRepo;
    private final BookingRepository bookingRepo;
    private final BookingSeatRepository bookingSeatRepo;
    private final PaymentRepository paymentRepo;
    private final NotificationService notificationService;

    public BookingService(ShowRepository showRepo,
                          ShowSeatRepository showSeatRepo,
                          BookingRepository bookingRepo,
                          BookingSeatRepository bookingSeatRepo,
                          PaymentRepository paymentRepo,
                          NotificationService notificationService) {
        this.showRepo = showRepo;
        this.showSeatRepo = showSeatRepo;
        this.bookingRepo = bookingRepo;
        this.bookingSeatRepo = bookingSeatRepo;
        this.paymentRepo = paymentRepo;
        this.notificationService = notificationService;
    }

    // Step 1: lock seats and create PENDING booking
    @Transactional
    public Booking createBooking(BookRequest req) {
        if (req == null) throw new IllegalArgumentException("Request is null");
        Show show = showRepo.findById(req.showId).orElseThrow();
        Booking booking = new Booking();
        booking.setUserEmail(req.userEmail);
        booking.setShow(show);
        booking.setStatus(Booking.Status.PENDING);

        // lock seats
        List<ShowSeat> seats = showSeatRepo.findAllById(req.showSeatIds);
        for (ShowSeat ss : seats) {
            if (ss.getStatus() != ShowSeat.Status.AVAILABLE) {
                throw new IllegalStateException("Seat not available: " + ss.getId());
            }
            ss.setStatus(ShowSeat.Status.LOCKED);
            showSeatRepo.save(ss);
            BookingSeat bs = new BookingSeat();
            bs.setShowSeat(ss);
            booking.getSeats().add(bs);
        }

        Booking saved = bookingRepo.save(booking);
        return saved;
    }

    // Step 2: simulate payment and confirm/cancel booking
    @Transactional
    public Payment makePayment(Long bookingId, double amount, boolean simulateSuccess) {
        Booking booking = bookingRepo.findById(bookingId).orElseThrow();
        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setAmount(amount);
        payment.setStatus(Payment.Status.INITIATED);
        payment.setPaymentTime(LocalDateTime.now());
        payment = paymentRepo.save(payment);

        boolean success = simulateSuccess; // caller decides

        if (success) {
            payment.setStatus(Payment.Status.SUCCESS);
            // mark seats as BOOKED
            for (BookingSeat bs : booking.getSeats()) {
                ShowSeat ss = bs.getShowSeat();
                ss.setStatus(ShowSeat.Status.BOOKED);
                showSeatRepo.save(ss);
            }
            booking.setStatus(Booking.Status.CONFIRMED);
            bookingRepo.save(booking);
            notificationService.sendBookingConfirmation(booking);
        } else {
            payment.setStatus(Payment.Status.FAILED);
            // release locks
            for (BookingSeat bs : booking.getSeats()) {
                ShowSeat ss = bs.getShowSeat();
                ss.setStatus(ShowSeat.Status.AVAILABLE);
                showSeatRepo.save(ss);
            }
            booking.setStatus(Booking.Status.CANCELLED);
            bookingRepo.save(booking);
            notificationService.sendBookingFailed(booking);
        }
        payment.setPaymentTime(LocalDateTime.now());
        return paymentRepo.save(payment);
    }

    public Booking getBooking(Long id) { return bookingRepo.findById(id).orElseThrow(); }
}
