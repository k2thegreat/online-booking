package com.booking.onlinebooking.database.dao;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity(name = "theatre")
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Theatre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long theatreId;
    private String address;
    private long pinCode;
    private int seatsCount;

    @OneToMany(mappedBy = "theatre",fetch = FetchType.LAZY)
    private List<Movie> movies;

}
