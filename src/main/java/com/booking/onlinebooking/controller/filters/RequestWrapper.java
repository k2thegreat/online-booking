package com.booking.onlinebooking.controller.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringWriter;

public class RequestWrapper extends HttpServletRequestWrapper {
    private final String body;

    public RequestWrapper(HttpServletRequest request) {
        super(request);
        StringWriter sw = new StringWriter();
        try {
            BufferedReader br = request.getReader();
            String line;
            while ((line = br.readLine()) != null) {
                sw.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        body = sw.toString();
    }

    public String getBody() {
        return body;
    }
}





