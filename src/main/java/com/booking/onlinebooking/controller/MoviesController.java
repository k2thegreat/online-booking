package com.booking.onlinebooking.controller;

import com.booking.onlinebooking.common.dto.MovieDTO;
import com.booking.onlinebooking.common.dto.Test;
import com.booking.onlinebooking.database.MovieRepository;
import com.booking.onlinebooking.database.dao.Movie;
import com.booking.onlinebooking.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MoviesController {

    private MovieRepository movieRepository;
    private MovieService movieService;

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovie(@RequestParam(defaultValue = "") String genre, @RequestParam(defaultValue = "") String lang, @RequestParam(defaultValue = "") String city) {
        Map<String, String> filters = new HashMap<>();
        filters.put("genre", genre);
        filters.put("lang", lang);
        filters.put("city", city);


        return new ResponseEntity(movieService.getMovies(filters), HttpStatus.OK);
    }


    @PostMapping(value = "/save-movie", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieRepository.save(movie); // saving here for now , to be moved to service
        System.out.println("Movie Request:-");
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }
}
