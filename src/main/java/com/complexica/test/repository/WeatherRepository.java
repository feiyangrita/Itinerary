package com.complexica.test.repository;

import com.complexica.test.model.CityEntity;
import com.complexica.test.model.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by feiyang on 30/9/21.
 */
@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
    List<WeatherEntity> findByCity(CityEntity cityEntity);
}
