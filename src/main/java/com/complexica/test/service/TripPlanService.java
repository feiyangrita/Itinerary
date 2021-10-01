package com.complexica.test.service;

import com.complexica.test.model.TripPlanEntity;

import java.util.List;
import java.util.Optional;

/**
 * Created by feiyang on 2/10/21.
 */
public interface TripPlanService {
    List<TripPlanEntity> listTripPlans();
    Optional<TripPlanEntity> listTripPlanById(Long id);
}
