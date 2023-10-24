package com.booking.onlinebooking.database;

import com.booking.onlinebooking.database.dao.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre,Long> {
}
