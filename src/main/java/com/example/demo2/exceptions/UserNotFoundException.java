package com.example.demo2.exceptions;

public class UserNotFoundException extends EVoterAppException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
