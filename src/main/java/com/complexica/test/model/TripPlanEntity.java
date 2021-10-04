package com.complexica.test.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by feiyang on 29/9/21.
 */
@Entity
@Table(name="plan")
public class TripPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String planName;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn( name = "plan_id")
    private List<TripStopEntity> tripStopEntities;

    //TODO: add creation time and update time column, so we can track users update trip plan.

    public List<TripStopEntity> getTripStopEntities() {
        return tripStopEntities;
    }

    public void setTripStopEntities(List<TripStopEntity> tripStopEntities) {
        this.tripStopEntities = tripStopEntities;
    }

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
