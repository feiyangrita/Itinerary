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


    private String planName;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    @JoinTable(name = "plan_t_tripstop",
            joinColumns = @JoinColumn(name = "plan_id"),
            inverseJoinColumns = @JoinColumn(name = "tripstop_id"))
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
