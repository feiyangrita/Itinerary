package com.complexica.test.controller;

import com.complexica.test.service.WeatherService;
import com.fasterxml.jackson.core.sym.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by feiyang on 29/9/21.
 */
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    private Map<String, Object> params;

    @RequestMapping(value = "/getweather", method = RequestMethod.GET)
    @ResponseBody
    public String getWeatherInfo(@RequestParam Map<String, Object> params) {
        String cityName = (String)params.get("city");
        String result  = weatherService.getWeatherByCity(cityName);
        return result;

    }
}
