package com.example.bookmyshow.entity;

import jakarta.persistence.*;

@Entity
public class Theatre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatreId;
    private String name;
    private String location;

    public Long getTheatreId() { return theatreId; }
    public void setTheatreId(Long theatreId) { this.theatreId = theatreId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
