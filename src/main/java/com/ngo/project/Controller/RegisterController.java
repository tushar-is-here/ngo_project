package com.ngo.project.Controller;

import com.ngo.project.Entity.*;
import com.ngo.project.Payload.LoginPayload;
import com.ngo.project.Payload.RegisterEmployeePayload;
import com.ngo.project.Payload.RegisterUserPayload;
import com.ngo.project.Repository.*;
import com.ngo.project.Response.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterController {
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private RegisterEmployeeRepository registerEmployeeRepository;

    @Autowired
    private RegisterUserTblRepository registerUserTblRepository;

    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private DistrictRepository districtRepository;

    @PostMapping("/registerEmployee")
    public String registerEmployee(@RequestBody RegisterEmployeePayload registerEmployeePayload){
        RegisterEmployee dbData = registerEmployeeRepository.findByPhoneNumber(registerEmployeePayload.getPhoneNumber());
        if(null == dbData){
            Login loginObj = new Login();
//            String username = "SS13";
//            LocalDateTime dd = LocalDateTime.now();
//            int digit = dd.getDayOfMonth();
//            username += digit;
//            username = username.concat(String.valueOf(registerEmployeePayload.getFirstName().charAt(0)));
//            username = username.concat(String.valueOf(registerEmployeePayload.getGender().charAt(0)));
//            Long maxId = 0l;
//            maxId = registerEmployeeRepository.getMaxId();
//            if(maxId == null) maxId = 0l;
//            String sequence = String.format("%03d", (maxId + 1));
//            loginObj.setUsername(username + sequence);
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

    @GetMapping("/getEmployeeData/{phoneNumber}")
    public RegisterEmployee getEmployeeData(@PathVariable String phoneNumber){
        return registerEmployeeRepository.findByPhoneNumber(phoneNumber);
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

            String username = "SS13";
            LocalDateTime dd = LocalDateTime.now();
            String date = String.valueOf(dd.getDayOfMonth());
            String month = String.valueOf(dd.getMonthValue());
            if(month.length()==1) month = "0" + month;
            String year = String.valueOf(dd.getYear());
            year = year.substring(2,4);
            username += year + month + date;
            username = username.concat(String.valueOf(registerUserPayload.getFirstName().charAt(0)));
            username = username.concat(String.valueOf(registerUserPayload.getGender().charAt(0)));
            Long maxId = 0l;
            maxId = registerUserTblRepository.getMaxId();
            String sequence = "";
            String maxCreatedOn = registerUserTblRepository.getCreatedOn();
            // Define a custom DateTimeFormatter to handle variable fractional seconds precision
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendPattern("yyyy-MM-dd HH:mm:ss")
                    .optionalStart()
                    .appendFraction(ChronoField.NANO_OF_SECOND, 0, 6, true)
                    .optionalEnd()
                    .toFormatter();

            // Parse maxCreatedOn to a LocalDateTime and then extract the date part
            LocalDate maxCreatedDate = LocalDateTime.parse(maxCreatedOn, formatter).toLocalDate();

            LocalDate currentDate = LocalDate.now();
            if(maxId == null || !maxCreatedDate.equals(currentDate)) {
                maxId = 0l;
            }
            sequence = String.format("%03d", (maxId + 1));
            registerUserTbl.setUserId(username + sequence);

            registerUserTblRepository.save(registerUserTbl);
            dbData = registerUserTblRepository.findByPhoneNumber(registerUserPayload.getPhoneNumber());
            response.setStatus("Success");
            response.setMsg("Successfully added new member");
            response.setData(dbData);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setStatus("Failed");
            response.setMsg("Already Exists!!!");
            response.setData(dbData);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/getState")
    public List<State> getState(){
        return stateRepository.findAll();
    }
    @GetMapping("/getCity/{districtId}")
    public List<City> getCity(@PathVariable int districtId){
        return cityRepository.findByDistrictId(districtId);
    }
    @GetMapping("/getDistrict/{stateId}")
    public List<District> getDistrict(@PathVariable int stateId){
        return districtRepository.findByStateId(stateId);
    }
}
