package com.ngo.project.Repository;

import com.ngo.project.Entity.RegisterUserTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegisterUserTblRepository extends JpaRepository<RegisterUserTbl, Long> {
    List<RegisterUserTbl> findByPhoneNumber(String phoneNumber);

    @Query(value="select id from register_user_tbl order by id desc limit 1",nativeQuery = true)
    Long getMaxId();
}
