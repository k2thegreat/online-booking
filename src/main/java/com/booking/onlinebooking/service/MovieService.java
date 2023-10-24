package com.booking.onlinebooking.service;

import com.booking.onlinebooking.common.dto.MovieDTO;
import com.booking.onlinebooking.database.MovieRepository;
import com.booking.onlinebooking.database.dao.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepo;

    public Collection<Movie> getMovies(Map<String, String> filter) {
        String genre = null, lang = null, city = null;

        for (Map.Entry e : filter.entrySet()) {
            switch ((String) e.getKey()) {
                case "genre":
                    genre = (String) e.getValue();
                    break;
                case "lang":
                    lang = (String) e.getValue();
                    break;
                case "city":
                    city = (String) e.getValue();
                    break;
            }
        }
        if (!StringUtils.isEmpty(genre) && !StringUtils.isEmpty(lang) && !StringUtils.isEmpty(city)) {
//            return movieRepo.findMoviesByGenreAndLangAndCity(genre, lang, city);
        } else if (!StringUtils.isEmpty(genre) && !StringUtils.isEmpty(lang)) {
//            return movieRepo.findMoviesByGenreAndLang(genre, lang);
        } else if (!StringUtils.isEmpty(genre)) {
//            return movieRepo.findMoviesByGenre(genre);
        }else if(!StringUtils.isEmpty(lang)){
            return movieRepo.findByLang(lang);
        }
        return null;
    }

}
