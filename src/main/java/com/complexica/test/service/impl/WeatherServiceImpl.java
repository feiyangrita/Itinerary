package com.complexica.test.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.complexica.test.config.OpenWeatherConfig;
import com.complexica.test.config.RestTemplateConfig;
import com.complexica.test.service.WeatherService;
import com.complexica.test.utils.WeatherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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
        String unit = openWeatherConfig.getUnit();
        //TODO: implement a request class to define different API from openWeatherMap
        String url = baseURL + cityName + "&appid=" + key + "&units=" + unit;
        try {
            ResponseEntity<String> response = restTemplateConfig.restTemplate().getForEntity(url, String.class);
            String result = response.getBody();
            WeatherUtil.getInstance().saveCityEntity(result);

            return response.getBody();
        } catch (HttpClientErrorException.Unauthorized e){
            return "Opps, there is something wrong when using openWeatherAPI, please contact developers.";
        } catch (HttpClientErrorException.NotFound e){
            return "";
        } finally {
            //TODO:
        }
    }
}
