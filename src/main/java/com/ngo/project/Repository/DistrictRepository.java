package com.ngo.project.Repository;

import com.ngo.project.Entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Integer> {
    List<District> findByStateId(int stateId);
}
