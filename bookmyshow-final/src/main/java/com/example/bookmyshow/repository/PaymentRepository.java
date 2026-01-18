package com.example.bookmyshow.repository;

import com.example.bookmyshow.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}
