package com.example.bookmyshow.repository;

import com.example.bookmyshow.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByScreen_Theatre_TheatreIdAndShowDate(Long theatreId, LocalDate date);
}
