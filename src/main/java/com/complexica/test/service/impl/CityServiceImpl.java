package com.complexica.test.service.impl;

import com.complexica.test.model.CityEntity;
import com.complexica.test.repository.CityRepository;
import com.complexica.test.service.CityService;
import com.complexica.test.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Created by feiyang on 30/9/21.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    WeatherService weatherService;

    @Override
    public List<CityEntity> getCitiesByCityName(String cityName) {
        return cityRepository.findByCityName(cityName);
    }

    @Override
    public List<CityEntity> getCitiesByCityNameAndDate(String cityName, Date startDate, Date endDate){
        List<CityEntity> cityEntities = getCitiesByCityName(cityName);
        cityEntities.forEach(
                entity ->{
                    entity.setWeatherEntities(weatherService.getWeatherByCityAndDate(entity, startDate, endDate));
                }
        );
        return cityEntities;
    }

    @Override
    public void deleteCityByName(String cityName){
        cityRepository.deleteByCityName(cityName);
    }

}
