package com.example.demo2.utils;

import com.example.demo2.data.model.Vote;
import com.example.demo2.data.model.Voter;
import com.example.demo2.data.repository.VoteRepository;
import com.example.demo2.data.repository.VoterRepository;
import com.example.demo2.dtos.Requests.CastVoteRequest;
import com.example.demo2.dtos.Requests.RegisterRequest;
import com.example.demo2.dtos.Response.FindVoterResponse;
import com.example.demo2.dtos.Response.VoteCastedResponse;
//import com.example.demo2.services.VoteService;

import java.util.Optional;


public class Mapper {
    private static VoterRepository voterRepository;
    private static VoteRepository voteRepository;
    public static void mapp(RegisterRequest registerRequest, FindVoterResponse findVoterResponse) {
//        FindVoterResponse findVoterResponse = new FindVoterResponse();
//        findVoterResponse.setUserId(registerRequest.);
        findVoterResponse.setFullName(registerRequest.getFirstName() + " " + registerRequest.getLastName());
        findVoterResponse.setAge(registerRequest.getAge());
        findVoterResponse.setValidVoter_sCardNumber(registerRequest.getValidVoter_sCardNumber());
        findVoterResponse.setUsername(registerRequest.getUsername());
//        return findVoterResponse;
    }

    public static void map(RegisterRequest registerRequest, Voter voter) {
        voter.setUsername(registerRequest.getUsername());
        voter.setValidVoter_sCardNumber(registerRequest.getValidVoter_sCardNumber());
        voter.setLastName(registerRequest.getLastName());
        voter.setFirstName(registerRequest.getFirstName());
        voter.setAge(registerRequest.getAge());
        voter.setPassword(registerRequest.getPassword());
    }


    public static FindVoterResponse mapp(Voter voter) {
        FindVoterResponse response = new FindVoterResponse();
        response.setFullName(voter.getFirstName() + " " + voter.getLastName());
        response.setAge(voter.getAge());
        response.setUsername(voter.getUsername());
        response.setValidVoter_sCardNumber(voter.getValidVoter_sCardNumber());
        return response;
    }

    public static void map(Optional<Voter> voter, FindVoterResponse response) {
        response.setFullName(voter.get().getFirstName() + " " + voter.get().getLastName());
        response.setUsername(voter.get().getUsername());
        response.setAge(voter.get().getAge());
        response.setValidVoter_sCardNumber(voter.get().getValidVoter_sCardNumber());
    }

    public static void map(CastVoteRequest castVoteRequest, Vote vote){
//        var voteCast =voterRepository.findByUsername(castVoteRequest.getUsername());
        vote.setUsername(castVoteRequest.getUsername());
        vote.setPoliticalParty(castVoteRequest.getPoliticalParty());
//        vote.setFullName(voteCast.getFirstName()+ " "+ voteCast.getLastName());
    }
    public static VoteCastedResponse mapp(Vote vote) {
        VoteCastedResponse response = new VoteCastedResponse();
        response.setUsername(vote.getUsername());
        response.setParty(vote.getPoliticalParty());
        return response;
    }
}