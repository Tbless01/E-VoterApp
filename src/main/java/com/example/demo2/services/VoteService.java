package com.example.demo2.services;

import com.example.demo2.data.model.PoliticalParty;
import com.example.demo2.data.model.Vote;
import com.example.demo2.dtos.Requests.CastVoteRequest;
import com.example.demo2.dtos.Response.FindVoterResponse;
import com.example.demo2.dtos.Response.PoliticalPartyCount;
import com.example.demo2.dtos.Response.VoteCastedResponse;
import com.example.demo2.exceptions.UserHasVotedException;
import com.example.demo2.exceptions.UserNotFoundException;
import com.example.demo2.exceptions.VoteAvailablePartyException;

import java.util.List;
import java.util.Optional;

public interface VoteService {
    VoteCastedResponse castVote(CastVoteRequest castVoteRequest) throws UserNotFoundException, UserHasVotedException, VoteAvailablePartyException;

    Optional<Vote> findVoteById(Long id);
    PoliticalPartyCount voteCountForParty(PoliticalParty politicalParty);

    //    FindVoterResponse findVote(int id);
//    PoliticalPartyCount findByPartyName(String candidate);

//    PoliticalPartyCount voteCountPerParty(PoliticalParty politicalParty);

    List<FindVoterResponse> findAll();
//long eachPoliticalParty(String party);
//    long count();
////    long eachPoliticalParty();
}
