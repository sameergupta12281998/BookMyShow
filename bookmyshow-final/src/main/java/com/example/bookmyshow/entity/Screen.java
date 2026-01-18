package com.example.bookmyshow.entity;

import jakarta.persistence.*;

@Entity
public class Screen {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screenId;

    @ManyToOne
    private Theatre theatre;

    private String name; // e.g., Screen 1

    public Long getScreenId() { return screenId; }
    public void setScreenId(Long screenId) { this.screenId = screenId; }
    public Theatre getTheatre() { return theatre; }
    public void setTheatre(Theatre theatre) { this.theatre = theatre; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
