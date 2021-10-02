package com.complexica.test.controller;

import com.complexica.test.model.CityEntity;
import com.complexica.test.model.TripPlanEntity;
import com.complexica.test.model.TripStopEntity;
import com.complexica.test.repository.TripPlanRepository;
import com.complexica.test.service.CityService;
import com.complexica.test.service.TripPlanService;
import com.complexica.test.service.TripStopService;
import com.complexica.test.service.WeatherService;
import com.complexica.test.utils.TripPlanEntityVO;
import com.complexica.test.utils.TripStopWeatherInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
    private WeatherService weatherService;

    @Autowired
    private TripPlanService tripPlanService;

    @Autowired
    private WeatherController weatherController;


    @Autowired
    private TripStopService tripStopService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public TripPlanEntity add(@RequestBody TripPlanEntity tripPlanEntity ) {
        return tripPlanService.addTripPlan(tripPlanEntity);
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
    public List<TripStopWeatherInfo> list(@PathVariable("id") Long id) {
        List<TripStopWeatherInfo> list = new ArrayList<>();
        tripPlanService.getTripPlanById(id).ifPresent(tripPlanEntity ->{
            tripPlanEntity.getTripStopEntities().forEach(tripStopEntity -> {
                System.out.println("trip stop query date is " + tripStopEntity.getTripDate());
                List<CityEntity> cities = weatherController.getWeatherInfo(tripStopEntity.getCityName(), tripStopEntity.getTripDate());
                if(cities.size() == 0){
                    TripStopWeatherInfo t = new TripStopWeatherInfo();
                    t.setCityName(tripStopEntity.getCityName());
                    t.setDisplayTripDate(tripStopEntity.getTripDate().toString());
                    t.setCountry(null);
                    t.setWeatherEntities(null);
                    list.add(t);
                }
                cities.forEach(city ->{
                    TripStopWeatherInfo t = new TripStopWeatherInfo();
                    t.setCityName(tripStopEntity.getCityName());
                    t.setDisplayTripDate(tripStopEntity.getTripDate().toString());
                    t.setCountry(city.getCountry());
                    t.setWeatherEntities(city.getWeatherEntities());
                    list.add(t);
                });
            });

        });

        return list;
    }

//    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public Optional<TripPlanEntity> list(@PathVariable("id") Long id) {
//        return tripPlanService.listTripPlanById(id);
//    }

}
