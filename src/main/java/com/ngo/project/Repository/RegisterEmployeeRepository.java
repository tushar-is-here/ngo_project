package com.ngo.project.Repository;

import com.ngo.project.Entity.RegisterEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegisterEmployeeRepository extends JpaRepository<RegisterEmployee, Long> {
    @Query(value="select id from register_employee order by id desc limit 1",nativeQuery = true)
    Long getMaxId();

    RegisterEmployee findByPhoneNumber(String phoneNumber);

//    @Query("SELECT re " +
//            "FROM RegisterEmployee re " +
//            "JOIN Login l ON re.phoneNumber = l.phoneNumber " +
//            "WHERE l.username = :username")
//    RegisterEmployee findDetailsByUsername(@Param("username") String username);

}
