package com.ngo.project.Repository;

import com.ngo.project.Entity.HaryanaDistrictData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HaryanaDistrictDataRepository extends JpaRepository<HaryanaDistrictData, Integer> {
    @Query(value = "select distinct(district_name) from haryana_district_data", nativeQuery = true)
    List<String> getDistrict();

    @Query(value = "SELECT distinct(block_name) FROM haryana_district_data where district_name = :district_name", nativeQuery = true)
    List<String> getBlock(@Param("district_name") String districtName);
}
