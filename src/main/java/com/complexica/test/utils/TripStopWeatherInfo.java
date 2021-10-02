package com.complexica.test.utils;

import com.complexica.test.model.TripStopEntity;
import com.complexica.test.model.WeatherEntity;

import javax.persistence.Transient;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by feiyang on 2/10/21.
 */
public class TripStopWeatherInfo {

    private String cityName;
    private String country;
    @Transient
    private String displayTripDate;

    private  List<WeatherEntity> weatherEntities;

    public String getCityName() {
        return cityName;
    }


//    public String getDisplayTripDate() {
//        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tripDate);
//    }
//
//    public void setDisplayTripDate(String displayTime) {
//        this.displayTripDate = displayTime;
//    }

        public String getDisplayTripDate() {
        return displayTripDate;
    }

    public void setDisplayTripDate(String displayTime) {
        this.displayTripDate = displayTime;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

//    public Date getTripDate() {
//        return tripDate;
//    }
//
//    public void setTripDate(Date tripDate) {
//        this.tripDate = tripDate;
//    }

    public List<WeatherEntity> getWeatherEntities() {
        return weatherEntities;
    }

    public void setWeatherEntities(List<WeatherEntity> weatherEntities) {
        this.weatherEntities = weatherEntities;
    }
}
