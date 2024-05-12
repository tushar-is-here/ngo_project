package com.ngo.project.Controller;

import com.ngo.project.Entity.Login;
import com.ngo.project.Entity.RegisterEmployee;
import com.ngo.project.Entity.RegisterUserTbl;
import com.ngo.project.Payload.LoginPayload;
import com.ngo.project.Payload.RegisterEmployeePayload;
import com.ngo.project.Payload.RegisterUserPayload;
import com.ngo.project.Repository.LoginRepository;
import com.ngo.project.Repository.RegisterEmployeeRepository;
import com.ngo.project.Repository.RegisterUserTblRepository;
import com.ngo.project.Response.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private RegisterEmployeeRepository registerEmployeeRepository;

    @Autowired
    private RegisterUserTblRepository registerUserTblRepository;

    @PostMapping("/registerEmployee")
    public String registerEmployee(@RequestBody RegisterEmployeePayload registerEmployeePayload){
        RegisterEmployee dbData = registerEmployeeRepository.findByPhoneNumber(registerEmployeePayload.getPhoneNumber());
        if(null == dbData){
            Login loginObj = new Login();
            String username = "SS13";
            LocalDateTime dd = LocalDateTime.now();
            int digit = dd.getDayOfMonth();
            username += digit;
            username = username.concat(String.valueOf(registerEmployeePayload.getFirstName().charAt(0)));
            username = username.concat(String.valueOf(registerEmployeePayload.getGender().charAt(0)));
            Long maxId = 0l;
            maxId = registerEmployeeRepository.getMaxId();
            if(maxId == null) maxId = 0l;
            String sequence = String.format("%03d", (maxId + 1));
            loginObj.setUsername(username + sequence);
            loginObj.setPassword(registerEmployeePayload.getPassword());
            loginObj.setPhoneNumber(registerEmployeePayload.getPhoneNumber());
            loginObj.setRole(registerEmployeePayload.getRole());
            loginRepository.save(loginObj);

            RegisterEmployee re = new RegisterEmployee();
            re.setFirstName(registerEmployeePayload.getFirstName());
            re.setLastName(registerEmployeePayload.getLastName());
            re.setPhoneNumber(registerEmployeePayload.getPhoneNumber());
            re.setEmail(registerEmployeePayload.getEmail());
            re.setGender(registerEmployeePayload.getGender());
            re.setAddress(registerEmployeePayload.getAddress());
            re.setDob(registerEmployeePayload.getDob());
            re.setPincode(registerEmployeePayload.getPincode());
            re.setRole(registerEmployeePayload.getRole());
            re.setPassword(registerEmployeePayload.getPassword());
            registerEmployeeRepository.save(re);

            return "Registration successfully completed";
        } else {
            return "User already registered";
        }
    }

    @GetMapping("/getEmployeeData/{username}")
    public RegisterEmployee getEmployeeData(@PathVariable String username){
        return registerEmployeeRepository.findDetailsByUsername(username);
    }

    @PostMapping("/registerUser/{flag}")
    public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody RegisterUserPayload registerUserPayload, @PathVariable String flag){
        List<RegisterUserTbl> dbData = registerUserTblRepository.findByPhoneNumber(registerUserPayload.getPhoneNumber());
        RegisterUserResponse response = new RegisterUserResponse();
        if(dbData.size()==0 || flag.equals("true")){
            RegisterUserTbl registerUserTbl = new RegisterUserTbl();
            registerUserTbl.setFirstName(registerUserPayload.getFirstName());
            registerUserTbl.setLastName(registerUserPayload.getLastName());
            registerUserTbl.setPhoneNumber(registerUserPayload.getPhoneNumber());
            registerUserTbl.setEmail(registerUserPayload.getEmail());
            registerUserTbl.setGender(registerUserPayload.getGender());
            registerUserTbl.setDob(registerUserPayload.getDob());
            registerUserTbl.setAddress(registerUserPayload.getAddress());
            registerUserTbl.setPincode(registerUserPayload.getPincode());
            registerUserTbl.setPurpose(registerUserPayload.getPurpose());

            registerUserTblRepository.save(registerUserTbl);
            dbData = registerUserTblRepository.findByPhoneNumber(registerUserPayload.getPhoneNumber());
            response.setStatus("Successfully added new member");
            response.setData(dbData);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setStatus("Already Exists!!!");
            response.setData(dbData);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
