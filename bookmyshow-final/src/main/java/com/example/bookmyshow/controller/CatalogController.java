package com.example.bookmyshow.controller;

import com.example.bookmyshow.entity.Show;
import com.example.bookmyshow.service.CatalogService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {
    private final CatalogService service;
    public CatalogController(CatalogService service) { this.service = service; }

    @GetMapping("/shows")
    public List<Show> getShows(@RequestParam Long theatreId, @RequestParam String date) {
        return service.getShows(theatreId, LocalDate.parse(date));
    }
}
