package com.complexica.test.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by feiyang on 30/9/21.
 */
@Entity
@Table(name="tripstop")
public class TripStopEntity {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cityName;
    private LocalDate queryDate;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public LocalDate getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(LocalDate queryDate) {
        this.queryDate = queryDate;
    }
}
