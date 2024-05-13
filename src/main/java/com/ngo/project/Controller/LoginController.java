package com.ngo.project.Controller;

import com.ngo.project.Entity.Login;
import com.ngo.project.Payload.LoginPayload;
import com.ngo.project.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginRepository loginRepository;
    @PostMapping("/login")
    public String login(@RequestBody LoginPayload loginPayload){
        Login dbData = loginRepository.findByUsername(loginPayload.getUsername());
        if(null == dbData) {
            return "User not found";
        }
        String dbPass = dbData.getPassword();
        int role = dbData.getRole();
        if(dbPass.equals(loginPayload.getPassword())){
            if(role != loginPayload.getRole()){
                return "Role is invalid";
            }
            return dbData.getUsername();
        }
        return "Login failed";
    }
}
