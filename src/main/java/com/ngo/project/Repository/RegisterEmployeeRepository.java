package com.ngo.project.Repository;

import com.ngo.project.Entity.RegisterEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegisterEmployeeRepository extends JpaRepository<RegisterEmployee, Long> {
    RegisterEmployee findByPhoneNumber(String phoneNumber);
}
