package com.example.bookmyshow.entity;

import jakarta.persistence.*;

@Entity
public class ShowSeat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.STRING)
    private Status status = Status.AVAILABLE;

    public static enum Status { AVAILABLE, LOCKED, BOOKED }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Show getShow() { return show; }
    public void setShow(Show show) { this.show = show; }
    public Seat getSeat() { return seat; }
    public void setSeat(Seat seat) { this.seat = seat; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
