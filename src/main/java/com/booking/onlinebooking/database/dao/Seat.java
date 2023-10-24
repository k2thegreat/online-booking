package com.booking.onlinebooking.database.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String seatNumber; // alphanumeric a1,b22
    private String seatType; // silver,gold

    private double cost;

    @ManyToOne
    @JoinColumn(name="theatre_id",referencedColumnName = "theatreId")
    private Theatre theatre;


}
