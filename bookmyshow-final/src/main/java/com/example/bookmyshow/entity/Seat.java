package com.example.bookmyshow.entity;

import jakarta.persistence.*;

@Entity
public class Seat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    @ManyToOne
    private Screen screen;

    private String seatNumber; // A1, A2...
    @ManyToOne
    private SeatType type;

    public Long getSeatId() { return seatId; }
    public void setSeatId(Long seatId) { this.seatId = seatId; }
    public Screen getScreen() { return screen; }
    public void setScreen(Screen screen) { this.screen = screen; }
    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
    public SeatType getType() { return type; }
    public void setType(SeatType type) { this.type = type; }
}
