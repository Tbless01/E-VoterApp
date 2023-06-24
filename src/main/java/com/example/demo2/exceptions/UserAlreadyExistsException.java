package com.example.demo2.exceptions;

public class UserAlreadyExistsException extends EVoterAppException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
