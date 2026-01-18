package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.*;
import com.example.bookmyshow.entity.*;
import com.example.bookmyshow.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService service;
    public BookingController(BookingService service) { this.service = service; }

    @PostMapping
    public BookResponse createBooking(@RequestBody BookRequest req) {
        try {
            Booking b = service.createBooking(req);
            BookResponse r = new BookResponse();
            r.bookingId = b.getBookingId();
            r.status = b.getStatus().name();
            r.message = "Booking created, pending payment";
            return r;
        } catch (Exception e) {
            BookResponse r = new BookResponse();
            r.message = "Failed: " + e.getMessage();
            return r;
        }
    }

    @PostMapping("/{bookingId}/pay")
    public String pay(@PathVariable Long bookingId, @RequestParam(defaultValue = "true") boolean success) {
        Booking b = service.getBooking(bookingId);
        double amount = 0.0;
        for (BookingSeat bs : b.getSeats()) {
            // for demo, price = 100 per seat
            amount += 100.0;
        }
        service.makePayment(bookingId, amount, success);
        return "Payment processed for booking " + bookingId;
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long id) {
        return service.getBooking(id);
    }
}
