package com.ngo.project.Repository;

import com.ngo.project.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByDistrictId(int districtId);
}
