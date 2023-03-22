package com.example.demo.services;

import com.example.demo.data.model.Voter;
import com.example.demo.data.repository.VoterRepository;
import com.example.demo.dtos.Requests.RegisterRequest;
import com.example.demo.dtos.Response.FindVoterResponse;
import com.example.demo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterServiceImpl implements VoterService {
    @Autowired
    private VoterRepository voterRepository;

    @Override
    public FindVoterResponse register(RegisterRequest registerRequest) {
        if (userExist(registerRequest.getUsername()))
            throw new IllegalArgumentException(registerRequest.getUsername() + " already exists");
        if (registerRequest.getAge() < 18)
            throw new IllegalArgumentException("Sorry, you are not eligible to vote");
        return Mapper.mapp(voterRepository.save(Mapper.map(registerRequest)));
    }

    private boolean userExist(String username) {
        Voter foundVoter = voterRepository.findByUsername(username);
        return foundVoter != null;
    }

    @Override
    public FindVoterResponse findVoter(int id) {
        Voter foundVoter = voterRepository.findById(id);
        if (foundVoter == null) throw new NullPointerException("Voter does not exist");
        FindVoterResponse response = new FindVoterResponse();
        Mapper.map(foundVoter, response);
        return response;
    }
}
