package com.example.demo2.services;

import com.example.demo2.dtos.Requests.RegisterRequest;
import com.example.demo2.dtos.Response.DeleteResponse;
import com.example.demo2.dtos.Response.FindVoterResponse;
import com.example.demo2.exceptions.UserNotFoundException;
import com.example.demo2.exceptions.UserRegistrationFailedException;
import com.example.demo2.exceptions.VoteEligibilityException;

public interface VoterService {
    FindVoterResponse register(RegisterRequest registerRequest) throws UserRegistrationFailedException, VoteEligibilityException;
    FindVoterResponse findVoter(Long id);
    FindVoterResponse findVoterByUsername(String username) throws UserNotFoundException;
    DeleteResponse deleteById(Long id);

}
