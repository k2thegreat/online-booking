package com.booking.onlinebooking.database.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity(name="booking_status")
public class BookingStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @ManyToOne
    @JoinColumn(name="theatre_id")
    private Theatre theatre;
    @ManyToOne
    @JoinColumn(name="seat_id")
    private Seat seat;
    private long fromTimeInMillis;
    private long toTimeInMillis;
    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    private int amount;




}
