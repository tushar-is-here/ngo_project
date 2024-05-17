package com.ngo.project.Response;

import com.ngo.project.Entity.RegisterUserTbl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserResponse {
    private String status;
    private String msg;
    private List<RegisterUserTbl> data;
}
