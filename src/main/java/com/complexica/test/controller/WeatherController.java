package com.complexica.test.controller;

import com.complexica.test.model.CityEntity;
import com.complexica.test.model.WeatherEntity;
import com.complexica.test.service.CityService;
import com.complexica.test.service.WeatherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by feiyang on 29/9/21.
 */
@RestController
@RequestMapping("/itinerary/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private CityService cityService;

//    @RequestMapping(value = "/weather", method = RequestMethod.GET)
//    @ResponseBody
//    public List<CityEntity> getWeatherInfo(
//            @RequestParam(name = "city", required = true) String cityName,
//            @RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startDate,
//            @RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss" ) Date endDate) {
//
//        weatherService.saveWeatherByCityName(cityName);
//        System.out.println(startDate.toString());
//        System.out.println(endDate.toString());
//        return cityService.getCitiesByCityNameAndDate(cityName, startDate, endDate);
//
//    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<CityEntity> getWeatherInfo(
            @RequestParam(name = "city", required = true) String cityName,
            @RequestParam(name = "date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date1) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.add(Calendar.HOUR, 12);
        Date startDate = calendar.getTime();
        calendar.add(Calendar.HOUR, 6);
        Date endDate = calendar.getTime();

        weatherService.saveWeatherByCityName(cityName);
        System.out.println(startDate.toString());
        System.out.println(endDate.toString());
        return cityService.getCitiesByCityNameAndDate(cityName, startDate, endDate);

    }

    @RequestMapping(value = "/forecast", method = RequestMethod.GET)
    @ApiOperation(value = "gg", notes = "Get 5 days weather forecast with specified city name.")
    @ResponseBody
    public List<CityEntity> getWeatherForecast(
            @RequestParam(name = "city", required = true) String cityName) {
        String result  = weatherService.saveWeatherByCityName(cityName);
        List<CityEntity> cityEntities = cityService.getCitiesByCityName(cityName);
        System.out.println(cityEntities.size());
        return cityEntities;

    }
}
