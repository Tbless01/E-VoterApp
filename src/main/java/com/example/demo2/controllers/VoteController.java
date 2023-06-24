package com.example.demo2.controllers;

import com.example.demo2.data.model.PoliticalParty;
import com.example.demo2.dtos.Requests.CastVoteRequest;
import com.example.demo2.exceptions.UserHasVotedException;
import com.example.demo2.exceptions.UserNotFoundException;
import com.example.demo2.exceptions.VoteAvailablePartyException;
import com.example.demo2.services.VoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping("/vote")
    public ResponseEntity<?> castVote(@RequestBody CastVoteRequest request) throws UserNotFoundException {
        try {
            var response =voteService.castVote(request);
            return ResponseEntity.ok(response);
        } catch (UserNotFoundException | UserHasVotedException | VoteAvailablePartyException e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
    @GetMapping("/{eachPartyCount}")
    public Object findPartyVoteCount(@PathVariable String eachPartyCount){
        return voteService.voteCountForParty(PoliticalParty.valueOf(eachPartyCount));
    }
}


