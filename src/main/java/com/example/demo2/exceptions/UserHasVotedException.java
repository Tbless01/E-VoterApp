package com.example.demo2.exceptions;

public class UserHasVotedException extends Throwable {
    public UserHasVotedException(String  message) {
        super(message);
    }
}
