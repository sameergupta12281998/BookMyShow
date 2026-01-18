package com.example.bookmyshow.service;

import com.example.bookmyshow.entity.Payment;
import com.example.bookmyshow.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentRepository repo;
    public PaymentService(PaymentRepository repo) { this.repo = repo; }
    public Payment getPayment(Long id) { return repo.findById(id).orElse(null); }
}
