package com.example.bookmyshow.repository;

import com.example.bookmyshow.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByScreen_ScreenId(Long screenId);
}
