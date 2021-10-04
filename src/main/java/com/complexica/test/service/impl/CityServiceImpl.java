package com.complexica.test.service.impl;

import com.complexica.test.model.CityEntity;
import com.complexica.test.model.WeatherEntity;
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
    public CityEntity getCityByCityAndDate(CityEntity cityEntity, Date startDate, Date endDate){
        List<WeatherEntity> weatherEntities = weatherService.getWeatherByCityAndDate(cityEntity, startDate, endDate);
        cityEntity.setWeatherEntities(weatherEntities);
        return cityEntity;
    }

    @Override
    public List<CityEntity> getCitiesByCityNameAndDate(String cityName, Date startDate, Date endDate){
        List<CityEntity> cityEntities = cityRepository.findByCityName(cityName);
        cityEntities.forEach(entity->{
            entity = getCityByCityAndDate(entity, startDate, endDate);
        });

        return cityEntities;
    }


    @Override
    public void deleteCityByName(String cityName){
        cityRepository.deleteByCityName(cityName);
    }


    /*
    * @
    * */
    @Override
    public boolean isCached(CityEntity cityEntity){
        LocalDateTime current = LocalDateTime.now();
        return cityEntity.getLastModifiedTime().plusHours(1).isAfter(current);
    }

    public void deleteCity(CityEntity cityEntity){
        weatherService.deleteWeatherByCity(cityEntity);
        cityRepository.delete(cityEntity);
    }

    @Override
    public void deleteCitiesByCityName(String cityName){
        List<CityEntity> cityEntities = cityRepository.findByCityName(cityName);
        cityEntities.forEach(this::deleteCity);
    }



}
