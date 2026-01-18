package com.example.bookmyshow.repository;

import com.example.bookmyshow.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {}
