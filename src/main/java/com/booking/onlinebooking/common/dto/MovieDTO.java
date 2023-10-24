package com.booking.onlinebooking.common.dto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Data
public class MovieDTO {

    private String name;
    private String cast;
    private String lang;
    private String   date;
    private String   fromTimeInMillis;
    private String   toTimeInMillis;
    private String price;

}
