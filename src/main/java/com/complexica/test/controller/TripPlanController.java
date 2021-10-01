package com.complexica.test.controller;

import com.complexica.test.model.CityEntity;
import com.complexica.test.model.TripPlanEntity;
import com.complexica.test.model.WeatherEntity;
import com.complexica.test.repository.TripPlanRepository;
import com.complexica.test.service.CityService;
import com.complexica.test.service.TripPlanService;
import com.complexica.test.service.WeatherService;
import com.complexica.test.utils.TripPlanEntityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by feiyang on 1/10/21.
 */
@RestController
@RequestMapping("/itinerary/plan")
public class TripPlanController {
    @Autowired
    private TripPlanRepository tripPlanRepository;

    @Autowired
    private CityService cityService;

    @Autowired
    private TripPlanService tripPlanService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public TripPlanEntity add(@RequestBody TripPlanEntity tripPlanEntity ) {
        return tripPlanRepository.save(tripPlanEntity);
    }

    @RequestMapping(value = "/listall", method = RequestMethod.GET)
    @ResponseBody
    public List<TripPlanEntity> listAll() {
        return tripPlanService.listTripPlans();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<TripPlanEntityVO> list() {
        List<TripPlanEntity> tripPlanEntities =  tripPlanService.listTripPlans();
        List<TripPlanEntityVO> tripPlanEntityVOs = new ArrayList<>();
        tripPlanEntities.forEach(entity -> {
            TripPlanEntityVO tripPlanEntityVO = new TripPlanEntityVO();
            tripPlanEntityVO.setId(entity.getId());
            tripPlanEntityVO.setPlanName(entity.getPlanName());
            tripPlanEntityVOs.add(tripPlanEntityVO);
        });

        return tripPlanEntityVOs;
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<TripPlanEntity> list(@PathVariable("id") Long id) {
        return tripPlanService.listTripPlanById(id);
    }

}
