package com.example.demo.data.model;

import lombok.Data;

@Data
public class Voter  {
    private int id;
    private String firstName;
    private String lastName;
    private String Username;
    private String validVoter_sCardNumber;
    private int age;
    private String password;
}
