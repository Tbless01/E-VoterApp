package com.example.demo2.services;

import com.example.demo2.data.model.Voter;
import com.example.demo2.data.repository.VoterRepository;
import com.example.demo2.dtos.Requests.RegisterRequest;
import com.example.demo2.dtos.Response.DeleteResponse;
import com.example.demo2.dtos.Response.FindVoterResponse;
import com.example.demo2.exceptions.UserNotFoundException;
import com.example.demo2.exceptions.UserRegistrationFailedException;
import com.example.demo2.exceptions.VoteEligibilityException;
import com.example.demo2.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo2.utils.ExceptionUtils.*;
import static com.example.demo2.utils.ResponseUtils.USER_DELETED_SUCCESSFULLY;


@Service
@AllArgsConstructor
public class VoterServiceImpl implements VoterService {

    private final VoterRepository voterRepository;

    @Override
    public FindVoterResponse register(RegisterRequest registerRequest) throws UserRegistrationFailedException, VoteEligibilityException {
        if (userExist(registerRequest.getUsername()))
            throw new UserRegistrationFailedException(String.format(USER_ALREADY_EXISTS, registerRequest.getUsername()));
        if (registerRequest.getAge() < 18) throw new VoteEligibilityException(YOU_ARE_NOT_ELIGIBLE_TO_VOTE);
        Voter voter = new Voter();
        Mapper.map(registerRequest, voter);
        Voter savedVoter = voterRepository.save(voter);
        var response = Mapper.mapp(savedVoter);
        return response;
    }

    private boolean userExist(String username) {
        Voter foundVoter = voterRepository.findByUsername(username);
        return foundVoter != null;
    }

    @Override
    public FindVoterResponse findVoter(Long id) {
        Optional<Voter> foundVoter = voterRepository.findById(id);
        if (foundVoter.isEmpty()) throw new NullPointerException(String.format(USER_WITH_ID_DOES_NOT_EXIST, id));
        FindVoterResponse response = new FindVoterResponse();
        Mapper.map(foundVoter, response);
        return response;
    }

    @Override
    public FindVoterResponse findVoterByUsername(String username) throws UserNotFoundException {
        Optional<Voter> foundVoter = Optional.of(voterRepository.findByUsername(username));
        Voter voter = foundVoter.orElseThrow(() -> new UserNotFoundException(
                String.format(USER_WITH_USERNAME_DOES_NOT_EXIST, username)
        ));
        FindVoterResponse response = new FindVoterResponse();
        Mapper.map(foundVoter, response);
        return response;
    }

    @Override
    public DeleteResponse deleteById(Long id) {
        Optional<Voter> foundVoter = voterRepository.findById(id);
        if (foundVoter.isEmpty()) throw new NullPointerException(String.format(USER_WITH_ID_DOES_NOT_EXIST, id));
        voterRepository.deleteById(id);
        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setMessage(USER_DELETED_SUCCESSFULLY);
        deleteResponse.setId(id);
        return deleteResponse;
    }
}
