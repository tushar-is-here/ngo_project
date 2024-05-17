package com.ngo.project.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginPayload {
    private String phoneNumber;
    private String password;
    private int role;
}
