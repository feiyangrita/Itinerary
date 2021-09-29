package com.complexica.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by feiyang on 29/9/21.
 */
@Component
@ConfigurationProperties(prefix = "openweather.api")
public class OpenWeatherConfig {

    private String baseURL;
    private String key;
    private String unit;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "OpenWeatherConfig{" +
                "baseURL='" + baseURL + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
