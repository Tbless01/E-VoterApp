package com.example.demo.controllers;

import com.example.demo.dtos.Requests.CastVoteRequest;
import com.example.demo.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoteController {
    @Autowired
    private VoteService voteService;

    @PostMapping("/vote")
    public Object castVote(@RequestBody CastVoteRequest request) {
        try {
            return voteService.castVote(request);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/vote/{party}")
    public Object findVote(@PathVariable String party) {
        try {
            return voteService.findByPartyName(party);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
    @GetMapping("/voteCount")
    public Object findAllVote() {
        return voteService.count();
    }
    @GetMapping("/{eachPartyCount}")
    public Object findPartyVoteCount(@PathVariable String eachPartyCount){
        return voteService.eachPoliticalParty(eachPartyCount);
    }
}


