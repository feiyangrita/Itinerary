package com.complexica.test.controller;

import com.complexica.test.model.CityEntity;
import com.complexica.test.model.TripPlanEntity;
import com.complexica.test.repository.TripPlanRepository;
import com.complexica.test.service.CityService;
import com.complexica.test.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public TripPlanEntity add(@RequestBody TripPlanEntity tripPlanEntity ) {

        return tripPlanRepository.save(tripPlanEntity);
    }
}
