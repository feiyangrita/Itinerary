package com.complexica.test.repository;

import com.complexica.test.model.CityForecastEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * Created by feiyang on 30/9/21.
 */

@Repository
public interface CityForecastRepository extends JpaRepository<CityForecastEntity, Long> {
}
