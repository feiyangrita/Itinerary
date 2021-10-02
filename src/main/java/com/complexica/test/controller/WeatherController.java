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
//    public List<CityEntity> getWeatherByCityAndDate(
//            @RequestParam(name = "city") String cityName,
//            @RequestParam(name = "startDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startDate,
//            @RequestParam(name = "endDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss" ) Date endDate) {
//
//        weatherService.saveWeatherByCityName(cityName);
//        return cityService.getCitiesByCityNameAndDate(cityName, startDate, endDate);
//
//    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<CityEntity> getWeatherInfo(
            @RequestParam(name = "city", required = true) String cityName,
            @RequestParam(name = "date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.HOUR, 12);
        Date startDate = calendar.getTime();
        calendar.add(Calendar.HOUR, 6);
        Date endDate = calendar.getTime();

        System.out.println("in weather controller");
        System.out.println(date);
        System.out.println(startDate);
        System.out.println(endDate);
        prepareData(cityName);
        return cityService.getCitiesByCityNameAndDate(cityName, startDate, endDate);

    }

    @RequestMapping(value = "/forecast", method = RequestMethod.GET)
    @ApiOperation(value = "gg", notes = "Get 5 days weather forecast with specified city name.")
    @ResponseBody
    public List<CityEntity> getWeatherForecast(
            @RequestParam(name = "city", required = true) String cityName) {
        prepareData(cityName);
        List<CityEntity> cityEntities = cityService.getCitiesByCityName(cityName);
        return cityEntities;

    }


    public boolean isCached(String cityName){
        List<CityEntity> cityEntities = cityService.getCitiesByCityName(cityName);
        if(cityEntities.size() == 0) {
            return false;
        } else {
            return cityService.isCached(cityEntities.get(0));
        }
    }

    public void deleteWeather(String cityName){
        cityService.getCitiesByCityName(cityName).forEach(cityEntity -> {
            weatherService.deleteWeatherByCity(cityEntity);
        });
        cityService.deleteCitiesByCityName(cityName);
    }

    public void prepareData(String cityName){
        if(!isCached(cityName)){
            deleteWeather(cityName);
            weatherService.saveWeatherByCityName(cityName);
        }
    }



}
