package com.example.demo.services;

import com.example.demo.data.model.Voter;
import com.example.demo.dtos.Requests.RegisterRequest;
import com.example.demo.dtos.Response.FindVoterResponse;

public interface VoterService {
    FindVoterResponse register(RegisterRequest registerRequest);
    FindVoterResponse findVoter(int id);

}
