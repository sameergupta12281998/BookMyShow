package com.example.bookmyshow.service;

import com.example.bookmyshow.entity.Booking;
import com.example.bookmyshow.entity.NotificationLog;
import com.example.bookmyshow.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationRepository repo;
    public NotificationService(NotificationRepository repo) { this.repo = repo; }

    public void sendBookingConfirmation(Booking booking) {
        NotificationLog n = new NotificationLog();
        n.setBooking(booking);
        n.setType("EMAIL");
        n.setMessage("Booking confirmed. BookingId: " + booking.getBookingId());
        repo.save(n);
        System.out.println("NOTIFICATION (EMAIL): " + n.getMessage());
    }

    public void sendBookingFailed(Booking booking) {
        NotificationLog n = new NotificationLog();
        n.setBooking(booking);
        n.setType("EMAIL");
        n.setMessage("Booking failed/cancelled. BookingId: " + booking.getBookingId());
        repo.save(n);
        System.out.println("NOTIFICATION (EMAIL): " + n.getMessage());
    }
}
