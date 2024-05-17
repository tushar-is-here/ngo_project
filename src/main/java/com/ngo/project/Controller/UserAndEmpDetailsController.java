package com.ngo.project.Controller;

import com.ngo.project.Entity.RegisterEmployee;
import com.ngo.project.Entity.RegisterUserTbl;
import com.ngo.project.Repository.RegisterEmployeeRepository;
import com.ngo.project.Repository.RegisterUserTblRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserAndEmpDetailsController {
    @Autowired
    private RegisterUserTblRepository registerUserTblRepository;
    @Autowired
    private RegisterEmployeeRepository registerEmployeeRepository;
    @GetMapping("/getAllUserDetails")
    public List<RegisterUserTbl> getAllUserDetails(){
        return registerUserTblRepository.findAll();
    }

    @GetMapping("/getAllEmpDetails")
    public List<RegisterEmployee> getAllEmpDetails(){
        return registerEmployeeRepository.findAll();
    }
}
