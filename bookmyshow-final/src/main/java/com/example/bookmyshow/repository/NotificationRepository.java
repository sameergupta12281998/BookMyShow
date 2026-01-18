package com.example.bookmyshow.repository;

import com.example.bookmyshow.entity.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationLog, Long> {}
