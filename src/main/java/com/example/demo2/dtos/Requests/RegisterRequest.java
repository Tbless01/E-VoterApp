package com.example.demo2.dtos.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String validVoter_sCardNumber;
    private String password;
    private int age;
}
