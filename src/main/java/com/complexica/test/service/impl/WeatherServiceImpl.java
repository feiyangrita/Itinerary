package com.complexica.test.service.impl;

import com.complexica.test.config.OpenWeatherConfig;
import com.complexica.test.config.RestTemplateConfig;
import com.complexica.test.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by feiyang on 29/9/21.
 */
@Service
public class WeatherServiceImpl implements WeatherService{
    @Autowired
    private RestTemplateConfig restTemplateConfig;

    @Autowired
    private OpenWeatherConfig openWeatherConfig;

    @Override
    public String getWeatherByCity(String cityName){

        String baseURL = openWeatherConfig.getBaseURL();
        String key = openWeatherConfig.getKey();
        String url = baseURL + cityName + "&appid=" + key;
        ResponseEntity<String> response = restTemplateConfig.restTemplate().getForEntity(url, String.class);
        return response.getBody();
    }
}
