package com.example.bookmyshow.service;

import com.example.bookmyshow.entity.Show;
import com.example.bookmyshow.repository.ShowRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class CatalogService {
    private final ShowRepository showRepository;
    public CatalogService(ShowRepository showRepository) { this.showRepository = showRepository; }
    public List<Show> getShows(Long theatreId, LocalDate date) {
        return showRepository.findByScreen_Theatre_TheatreIdAndShowDate(theatreId, date);
    }
}
