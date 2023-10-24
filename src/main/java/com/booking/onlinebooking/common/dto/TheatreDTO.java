package com.booking.onlinebooking.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TheatreDTO {

    private String address;
    private String pinCode;
    private String seatsCount;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(String seatsCount) {
        this.seatsCount = seatsCount;
    }
    private Set<MovieDTO> movies;
}
