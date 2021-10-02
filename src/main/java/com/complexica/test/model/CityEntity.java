package com.complexica.test.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by feiyang on 30/9/21.
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="city")
public class CityEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName;
    private String country;

    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;


    @LastModifiedDate
    @Column(name = "modify_time")
    private LocalDateTime lastModifiedTime;

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
                ", country='" + country + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + lastModifiedTime +
                ", weatherEntities=" + weatherEntities +
                '}';
    }
}
