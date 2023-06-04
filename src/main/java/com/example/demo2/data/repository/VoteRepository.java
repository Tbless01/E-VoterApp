package com.example.demo.data.repository;

import com.example.demo.data.model.Vote;

import java.util.List;

public interface VoteRepository {
    Vote save(Vote vote) ;
    Vote findById(int id);
    Vote findByPartyName(String party);
    long countVote();
    long eachPartyVoteCount(String party);
    List<Vote> findAll();
    void delete(Vote vote);
    void delete(int id);
    void deleteAll();
}

