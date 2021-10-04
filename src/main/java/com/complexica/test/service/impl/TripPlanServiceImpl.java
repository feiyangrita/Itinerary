package com.complexica.test.service.impl;

import com.complexica.test.model.TripPlanEntity;
import com.complexica.test.model.TripStopEntity;
import com.complexica.test.repository.TripPlanRepository;
import com.complexica.test.service.TripPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by feiyang on 2/10/21.
 */
@Service
public class TripPlanServiceImpl implements TripPlanService {
    @Autowired
    private TripPlanRepository tripPlanRepository;

    @Override
    public List<TripPlanEntity> listTripPlans(){
        return tripPlanRepository.findAll();
    }

    @Override
    public Optional<TripPlanEntity> getTripPlanById(Long id){
        return tripPlanRepository.findById(id);
    }

    @Override
    public TripPlanEntity addTripPlan(TripPlanEntity tripPlanEntity){
        List<TripStopEntity> tripStopEntities = tripPlanEntity.getTripStopEntities();
        Calendar calendar = Calendar.getInstance();
        tripStopEntities.forEach( tripStopEntity -> {
            calendar.setTime(tripStopEntity.getTripDate());
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            tripStopEntity.setTripDate(calendar.getTime());
            }
        );
        return tripPlanRepository.save(tripPlanEntity);
    }
}
