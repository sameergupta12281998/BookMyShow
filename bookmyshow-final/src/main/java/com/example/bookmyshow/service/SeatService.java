package com.example.bookmyshow.service;

import com.example.bookmyshow.entity.ShowSeat;
import com.example.bookmyshow.repository.ShowSeatRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeatService {
    private final ShowSeatRepository repo;
    public SeatService(ShowSeatRepository repo) { this.repo = repo; }
    public List<ShowSeat> getSeatsForShow(Long showId) { return repo.findByShow_ShowId(showId); }
}
