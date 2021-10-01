package com.complexica.test.service.impl;

import com.complexica.test.model.TripPlanEntity;
import com.complexica.test.repository.TripPlanRepository;
import com.complexica.test.service.TripPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by feiyang on 2/10/21.
 */
@Service
public class TripPlanServiceImpl implements TripPlanService {
    @Autowired
    TripPlanRepository tripPlanRepository;

    @Override
    public List<TripPlanEntity> listTripPlans(){
        return tripPlanRepository.findAll();
    }

    @Override
    public Optional<TripPlanEntity> listTripPlanById(Long id){
        return tripPlanRepository.findById(id);
    }
}
