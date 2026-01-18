package com.example.bookmyshow.repository;

import com.example.bookmyshow.entity.ShowSeat;
import com.example.bookmyshow.entity.ShowSeat.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findByShow_ShowId(Long showId);
    List<ShowSeat> findByShow_ShowIdAndStatus(Long showId, Status status);
}
