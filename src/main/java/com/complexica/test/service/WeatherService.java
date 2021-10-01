package com.complexica.test.service;

import com.complexica.test.model.CityEntity;
import com.complexica.test.model.WeatherEntity;

import java.util.List;

/**
 * Created by feiyang on 29/9/21.
 */
public interface WeatherService {

    String saveWeatherByCityName(String cityName);
    List<WeatherEntity> getWeatherByCity(CityEntity cityEntity);

}
