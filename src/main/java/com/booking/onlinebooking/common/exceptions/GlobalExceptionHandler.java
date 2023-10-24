package com.booking.onlinebooking.common.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private ObjectMapper mapper;

    @ExceptionHandler(BookingException.class)
    public ResponseEntity<Object> handleCityNotFoundException(
            BookingException ex, WebRequest request) {
        return new ResponseEntity<>(ex, ex.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> globalException(
            Exception ex, WebRequest request) {
        ex.printStackTrace();
        return new ResponseEntity<>(new CustomException("Global Exception","Some error occured","BA_100_001"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class CustomException{
        private String message;
        private String description;
        private String errorCode;
    }
}
