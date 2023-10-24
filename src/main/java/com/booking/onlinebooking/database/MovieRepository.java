package com.booking.onlinebooking.database;


import com.booking.onlinebooking.common.dto.MovieDTO;
import com.booking.onlinebooking.database.dao.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "select * from movie m where m.genre like :genre",nativeQuery = true)
    Collection<Movie> findMoviesByGenre(@Param("genre") String genre);

   /* @Query("select * from movie where genre like :genre and lang like :lang")
    Collection<Movie> findMoviesByGenreAndLang(@Param("genre") String genre, @Param("lang") String lang);

    @Query("select * from movie where genre like :genre and lang like :lang and city like :city")
    Collection<Movie> findMoviesByGenreAndLangAndCity(@Param("genre") String genre, @Param("lang") String lang, @Param("city") String city);
*/
    @Query(value = "select cast,date,lang,name,price,from_time_in_millis,to_time_in_millis from movie  where lang like :lang",nativeQuery = true)
    Collection<MovieDTO> findMoviesByLang(@Param("lang") String lang);

    Collection<Movie> findByLang(String lang);
}
