package com.example.demo2.dtos.Response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FindVoterResponse {
    private String username;
    private String fullName;
    private int age;
    private String validVoter_sCardNumber;
}
