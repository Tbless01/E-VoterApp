package com.example.demo.utils;

import com.example.demo.data.model.Vote;
import com.example.demo.data.model.Voter;
import com.example.demo.data.repository.VoteRepository;
import com.example.demo.data.repository.VoteRepositoryImpl;
import com.example.demo.data.repository.VoterRepository;
import com.example.demo.dtos.Requests.CastVoteRequest;
import com.example.demo.dtos.Requests.RegisterRequest;
import com.example.demo.dtos.Response.FindVoterResponse;
import com.example.demo.dtos.Response.VoteCastedResponse;
import com.example.demo.services.VoteService;
import com.example.demo.services.VoterService;


public class Mapper {
    private static VoterRepository voterRepository;
    private static VoteRepository voteRepository;
    private static VoteService voteService;

    public static Voter map(RegisterRequest registerRequest) {
        Voter voter = new Voter();
        voter.setFirstName(registerRequest.getFirstName());
        voter.setLastName(registerRequest.getLastName());
        voter.setUsername(registerRequest.getUsername());
        voter.setAge(registerRequest.getAge());
        voter.setValidVoter_sCardNumber(registerRequest.getValidVoter_sCardNumber());
        voter.setPassword(registerRequest.getPassword());
        return voter;
    }
    public static void mapp(RegisterRequest registerRequest, FindVoterResponse findVoterResponse){
//        FindVoterResponse findVoterResponse = new FindVoterResponse();
//        findVoterResponse.setUserId(registerRequest.);
        findVoterResponse.setFullName(registerRequest.getFirstName() + " " + registerRequest.getLastName());
        findVoterResponse.setAge(registerRequest.getAge());
        findVoterResponse.setValidVoter_sCardNumber(registerRequest.getValidVoter_sCardNumber());
        findVoterResponse.setUsername(registerRequest.getUsername());
//        return findVoterResponse;
    }

    //    OR
    public static void map(RegisterRequest registerRequest, Voter voter) {
        voter.setUsername(registerRequest.getUsername());
        voter.setValidVoter_sCardNumber(registerRequest.getValidVoter_sCardNumber());
        voter.setLastName(registerRequest.getLastName());
        voter.setFirstName(registerRequest.getFirstName());
        voter.setAge(registerRequest.getAge());
        voter.setPassword(registerRequest.getPassword());
    }

    public static void map(Voter foundUser, FindVoterResponse response) {
        response.setFullName(foundUser.getFirstName() + " " + foundUser.getLastName());
        response.setUserId(foundUser.getId());
        response.setUsername(foundUser.getUsername());
        response.setValidVoter_sCardNumber(foundUser.getValidVoter_sCardNumber());
    }

    public static void map(int id) {
        Voter foundVoter = voterRepository.findById(id);
        FindVoterResponse response = new FindVoterResponse();
        response.setFullName(foundVoter.getFirstName() + " " + foundVoter.getLastName());
        response.setUserId(foundVoter.getId());
        response.setUsername(foundVoter.getUsername());
    }

    public static void map(CastVoteRequest castVoteRequest, Vote vote) {
        vote.setCandidate(castVoteRequest.getPoliticalParty().toUpperCase());
        vote.setVoterID(castVoteRequest.getVoterId());
    }
    public static void map(Vote foundVote, CastVoteRequest castResponse) {
        castResponse.setPoliticalParty(foundVote.getCandidate());
//        response.setUsername(foundUser.getUsername());
//        response.setValidVoter_sCardNumber(foundUser.getValidVoter_sCardNumber());
    }

    public static void map(Vote foundVote, VoteCastedResponse castResponse) {
        VoteRepository voteRepository1 = new VoteRepositoryImpl();
        castResponse.setParty(foundVote.getCandidate());
//        castResponse.setTotalCount(voteService.count());

//        castResponse.setVoterId(foundVote.getVoterID());
    }

    public static FindVoterResponse mapp(Voter voter) {
        FindVoterResponse response = new FindVoterResponse();
        response.setUserId(voter.getId());
        response.setFullName(voter.getFirstName()+ " " +voter.getLastName());
        response.setAge(voter.getAge());
        response.setUsername(voter.getUsername());
        response.setValidVoter_sCardNumber(voter.getValidVoter_sCardNumber());
        return response;
    }
    public static VoteCastedResponse mapp(Vote vote){
        VoteCastedResponse voteCastedResponse = new VoteCastedResponse();
        voteCastedResponse.setParty(vote.getCandidate());
        voteCastedResponse.setTotalCount(vote.getId());
        return voteCastedResponse;
    }
}


