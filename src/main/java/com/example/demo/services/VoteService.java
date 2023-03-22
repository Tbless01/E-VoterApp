package com.example.demo.services;

import com.example.demo.data.model.Vote;
import com.example.demo.dtos.Requests.CastVoteRequest;
import com.example.demo.dtos.Response.FindVoterResponse;
import com.example.demo.dtos.Response.VoteCastedResponse;

public interface VoteService {
    VoteCastedResponse castVote(CastVoteRequest castVoteRequest);

    Vote findVote(int id);
    VoteCastedResponse findByPartyName(String candidate);
//    FindVoterResponse findAll();

    long count();
}
