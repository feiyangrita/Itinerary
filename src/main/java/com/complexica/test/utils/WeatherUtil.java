package com.complexica.test.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.complexica.test.model.CityForecastEntity;
import com.complexica.test.model.WeatherEntity;
import com.complexica.test.repository.CityForecastRepository;
import com.complexica.test.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by feiyang on 30/9/21.
 */
@Component
public class WeatherUtil {

    private WeatherUtil(){};
    private static WeatherUtil weatherUtil;
    public static WeatherUtil getInstance() {
        if (weatherUtil == null) {
            weatherUtil = new WeatherUtil();
        }
        return weatherUtil;
    }
    @Autowired
    public CityForecastRepository cityForecastRepository;

    @Autowired
    public WeatherRepository weatherRepository;

    public List<WeatherEntity> saveWeatherEntity(String result){
        List<WeatherEntity> weatherEntities = new ArrayList<WeatherEntity>();
        JSONObject jsonObject = JSON.parseObject(result);

        JSONArray weatherArray = jsonObject.getJSONArray("list");
        for(Object i: weatherArray){
            JSONObject weatherObject = JSON.parseObject(i.toString());
            WeatherEntity weatherEntity = new WeatherEntity();
            weatherEntity.setCloud(weatherObject.getJSONObject("clouds").getInteger("all"));
            weatherEntity.setTemperature(weatherObject.getJSONObject("main").getDouble("temp"));
            weatherEntity.setDate(weatherObject.getString("dt_txt"));
            System.out.println(weatherEntity);
//            weatherRepository.save(weatherEntity);
            weatherEntities.add(weatherEntity);
        }

        weatherRepository.saveAll(weatherEntities);
        return weatherEntities;

    }


    public CityForecastEntity saveCityEntity(String result){
        JSONObject jsonObject = JSON.parseObject(result);

        JSONObject cityObject = jsonObject.getJSONObject("city");
        String cityName = cityObject.get("name").toString().toLowerCase();
        String cityCode = cityObject.get("country").toString().toLowerCase();

        CityForecastEntity cityForecastEntity = new CityForecastEntity();
        cityForecastEntity.setCode(cityCode);
        cityForecastEntity.setCityName(cityName);
        List<WeatherEntity> weatherEntities = saveWeatherEntity(result);
        cityForecastEntity.setWeatherEntities(weatherEntities);

        cityForecastRepository.save(cityForecastEntity);
        return cityForecastEntity;

    }
}
