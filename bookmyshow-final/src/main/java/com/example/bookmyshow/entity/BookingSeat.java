package com.example.bookmyshow.entity;

import jakarta.persistence.*;

@Entity
public class BookingSeat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ShowSeat showSeat;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ShowSeat getShowSeat() { return showSeat; }
    public void setShowSeat(ShowSeat showSeat) { this.showSeat = showSeat; }
}
