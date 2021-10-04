package com.complexica.test.utils;

import com.complexica.test.model.TripStopEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by feiyang on 29/9/21.
 */

public class TripPlanEntityVO {

    private Long id;

    private String planName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }


}
