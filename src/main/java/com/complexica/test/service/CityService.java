package com.complexica.test.service;

import com.complexica.test.model.CityEntity;
import com.complexica.test.model.WeatherEntity;

import java.util.List;

/**
 * Created by feiyang on 30/9/21.
 */
public interface CityService {

    List<CityEntity> getCitiesByCityName(String cityName);
}
