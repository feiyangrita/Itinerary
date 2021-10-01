package com.complexica.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by feiyang on 30/9/21.
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="city", indexes = {@Index(columnList = "cityName, code")})
public class CityEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName;
    private String code;

    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;


    @LastModifiedDate
    @Column(name = "modify_time")
    private Date modifyTime;

    //// TODO: 30/9/21 了解这个是做什么的
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

    @Override
    public String toString() {
        return "CityEntity{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", code='" + code + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", weatherEntities=" + weatherEntities +
                '}';
    }
}
