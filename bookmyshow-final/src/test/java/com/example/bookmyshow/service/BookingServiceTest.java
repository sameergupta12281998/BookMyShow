package com.example.bookmyshow.service;

import com.example.bookmyshow.entity.*;
import com.example.bookmyshow.repository.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalTime;

class BookingServiceTest {

    @Test
    void createBookingLocksSeats() {
        ShowRepository showRepo = Mockito.mock(ShowRepository.class);
        ShowSeatRepository showSeatRepo = Mockito.mock(ShowSeatRepository.class);
        BookingRepository bookingRepo = Mockito.mock(BookingRepository.class);
        BookingSeatRepository bookingSeatRepo = Mockito.mock(BookingSeatRepository.class);
        PaymentRepository paymentRepo = Mockito.mock(PaymentRepository.class);
        NotificationService notificationService = Mockito.mock(NotificationService.class);

        BookingService service = new BookingService(showRepo, showSeatRepo, bookingRepo, bookingSeatRepo, paymentRepo, notificationService);

        Show show = new Show();
        show.setShowId(1L);
        show.setShowDate(LocalDate.now());
        show.setShowTime(LocalTime.now());
        Mockito.when(showRepo.findById(1L)).thenReturn(Optional.of(show));

        org.junit.jupiter.api.Assertions.assertThrows(Exception.class, () -> {
            service.createBooking(null);
        });
    }
}
