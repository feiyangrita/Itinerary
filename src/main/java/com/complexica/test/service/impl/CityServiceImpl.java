package com.complexica.test.service.impl;

import com.complexica.test.model.CityEntity;
import com.complexica.test.repository.CityRepository;
import com.complexica.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by feiyang on 30/9/21.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public List<CityEntity> getCitiesByCityName(String cityName) {
        return cityRepository.findByCityName(cityName);
    }
}
