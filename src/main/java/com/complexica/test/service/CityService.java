package com.complexica.test.service;

import com.complexica.test.model.CityEntity;
import com.complexica.test.model.WeatherEntity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by feiyang on 30/9/21.
 */
public interface CityService {

    List<CityEntity> getCitiesByCityName(String cityName);

    CityEntity getCityByCityAndDate(CityEntity cityEntity, Date startDate, Date endDate);

    List<CityEntity> getCitiesByCityNameAndDate(String cityName, Date startDate, Date endDate);

    void deleteCityByName(String cityName);

    void deleteCitiesByCityName(String cityName);

    boolean isCached(CityEntity cityEntity);
}
