package com.complexica.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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
    private Date queryDate;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plan_id", nullable = false)
//    @JsonIgnore
//    private TripPlanEntity plan;

//    public TripPlanEntity getPlan() {
//        return plan;
//    }
//
//    public void setPlan(TripPlanEntity plan) {
//        this.plan = plan;
//    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(Date queryDate) {
        this.queryDate = queryDate;
    }
}
