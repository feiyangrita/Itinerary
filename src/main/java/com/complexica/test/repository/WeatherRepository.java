package com.complexica.test.repository;

import com.complexica.test.model.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by feiyang on 30/9/21.
 */
@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
}
