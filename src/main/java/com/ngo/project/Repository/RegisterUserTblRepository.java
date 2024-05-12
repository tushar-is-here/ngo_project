package com.ngo.project.Repository;

import com.ngo.project.Entity.RegisterUserTbl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterUserTblRepository extends JpaRepository<RegisterUserTbl, Long> {
    List<RegisterUserTbl> findByPhoneNumber(String phoneNumber);
}
