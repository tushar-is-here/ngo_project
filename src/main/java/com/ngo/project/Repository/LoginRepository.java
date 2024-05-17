package com.ngo.project.Repository;

import com.ngo.project.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,Long> {
    Login findByPhoneNumber(String phoneNumber);
}
