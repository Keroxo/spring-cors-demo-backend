package com.example.springcorsdemobackend.controller;

import org.springframework.http.CacheControl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RestController
public class DataController {

    @CrossOrigin
    @GetMapping("data")
    Object getData(HttpServletResponse response) {
        String headerValue = CacheControl.maxAge(60, TimeUnit.SECONDS)
                .getHeaderValue();

        response.addHeader("Cache-Control", headerValue);

        HashMap map = new HashMap<String, String>();
        map.put("foo", "bar");
        return map;
    }
}
