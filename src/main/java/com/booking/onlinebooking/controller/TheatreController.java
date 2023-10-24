package com.booking.onlinebooking.controller;

import com.booking.onlinebooking.common.dto.Test;
import com.booking.onlinebooking.common.dto.TheatreDTO;
import com.booking.onlinebooking.database.MovieRepository;
import com.booking.onlinebooking.database.TheatreRepository;
import com.booking.onlinebooking.database.dao.Movie;
import com.booking.onlinebooking.database.dao.Theatre;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/theatres")
@AllArgsConstructor
public class TheatreController {
    private TheatreRepository theatreRepo;
    private MovieRepository movieRepo;
    private ObjectMapper mapper;

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Theatre> saveTheatre(@RequestBody TheatreDTO theatreDTO){
        Theatre thtr = mapper.convertValue(theatreDTO,Theatre.class);
        Theatre t = theatreRepo.save(thtr);
        System.out.println(thtr);
        for(Movie m : thtr.getMovies()){
            m.setTheatre(t);
            movieRepo.save(m);
        }
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }

    @GetMapping("/fetch")
    public String getTheatres(){
        return "PVR";
    }


}
