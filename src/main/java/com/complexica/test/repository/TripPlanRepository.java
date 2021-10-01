package com.complexica.test.repository;


import com.complexica.test.model.CityEntity;
import com.complexica.test.model.TripPlanEntity;
import com.complexica.test.model.TripStopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by feiyang on 1/10/21.
 */

@Repository
public interface TripPlanRepository extends JpaRepository<TripPlanEntity, Long> {
    TripPlanEntity findByPlanName(String planName);
}
