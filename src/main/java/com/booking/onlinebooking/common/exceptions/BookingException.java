package com.booking.onlinebooking.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNullFields;

@Data
@AllArgsConstructor
public class BookingException extends RuntimeException{
    private HttpStatus statusCode;
    private String description;
    private String errorCode;
    public BookingException(String message){
        super(message);
    }

    public BookingException(String message,String errorCode,String desc){
        super(message);
        this.errorCode = errorCode;
        this.description = desc;
    }
}
