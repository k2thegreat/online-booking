package com.booking.onlinebooking.database.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name="movie")
@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String cast;
    private String lang;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private String   date;
    private long   fromTimeInMillis;
    private long   toTimeInMillis;
    private double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id")
    @JsonIgnore
    private Theatre theatre;
}
