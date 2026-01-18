package com.example.bookmyshow.controller;

import com.example.bookmyshow.entity.ShowSeat;
import com.example.bookmyshow.service.SeatService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class SeatController {
    private final SeatService service;
    public SeatController(SeatService service) { this.service = service; }

    @GetMapping("/{showId}/seats")
    public List<ShowSeat> getSeats(@PathVariable Long showId) {
        return service.getSeatsForShow(showId);
    }
}
