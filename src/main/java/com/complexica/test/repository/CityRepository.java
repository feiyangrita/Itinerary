package com.complexica.test.repository;

import com.complexica.test.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by feiyang on 30/9/21.
 */

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    List<CityEntity> findByCityName(String cityName);

    void deleteByCityName(String cityName);
}
