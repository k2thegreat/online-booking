package com.booking.onlinebooking.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfigurations {

    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
}
