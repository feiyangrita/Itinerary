package com.complexica.test.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by feiyang on 30/9/21.
 */

@Entity
@Table(name="forecast")
public class CityForecastEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName;
    private String code;

    
    //// TODO: 30/9/21 了解这个是做什么的
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    @JoinTable(name = "forecast_t_weather",
            joinColumns = @JoinColumn(name = "forecast_id"),
            inverseJoinColumns = @JoinColumn(name = "weather_id"))
    private List<WeatherEntity> weatherEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<WeatherEntity> getWeatherEntities() {
        return weatherEntities;
    }

    public void setWeatherEntities(List<WeatherEntity> weatherEntities) {
        this.weatherEntities = weatherEntities;
    }
}
