package com.example.demo.services;

import com.example.demo.dtos.Requests.PoliticalParty;
import com.example.demo.data.model.Vote;
import com.example.demo.data.repository.VoteRepository;
import com.example.demo.dtos.Requests.CastVoteRequest;
import com.example.demo.dtos.Response.VoteCastedResponse;
import com.example.demo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    VoteRepository voteRepository;
    @Autowired
    VoterService voterService;

    @Override
    public VoteCastedResponse castVote(CastVoteRequest castVoteRequest) {
        checkIfVoterExistsFrom(castVoteRequest);
        if (castVoteRequest.getPoliticalParty().equalsIgnoreCase(PoliticalParty.APC.getFillCell()) || castVoteRequest.getPoliticalParty().equalsIgnoreCase(PoliticalParty.PDP.getFillCell()) || castVoteRequest.getPoliticalParty().equalsIgnoreCase(PoliticalParty.LP.getFillCell()) || castVoteRequest.getPoliticalParty().equalsIgnoreCase(PoliticalParty.NNPP.getFillCell()) || castVoteRequest.getPoliticalParty().equalsIgnoreCase(PoliticalParty.AA.getFillCell())) {
            if (citizenHasVoted(castVoteRequest.getVoterId()) && citizenHasVotedByName(castVoteRequest.getPoliticalParty()))
                throw new IllegalArgumentException("Citizen with id " + castVoteRequest.getVoterId() + " has already voted.\n One citizen is not allowed to vote twice.");
            Vote vote = new Vote();
            Mapper.map(castVoteRequest, vote);
            return Mapper.mapp(voteRepository.save(vote));
        }
        throw new IllegalArgumentException("There is no such party. Vote for one of the available parties.");
    }

    @Override
    public Vote findVote(int id) {
        return voteRepository.findById(id);
    }

    @Override
    public VoteCastedResponse findByPartyName(String candidate) {
        Vote foundVote = voteRepository.findByPartyName(candidate);
        if (foundVote == null) throw new NullPointerException("Party does not exist");
        VoteCastedResponse castResponse = new VoteCastedResponse();
        Mapper.map(foundVote, castResponse);
        return castResponse;
    }

    private boolean citizenHasVoted(int id) {
        var foundVote = voteRepository.findById(id);
        return foundVote != null;
    }
    private boolean citizenHasVotedByName(String partyName) {
        var foundVote = voteRepository.findByPartyName(partyName);
        return foundVote != null;
    }

    private void checkIfVoterExistsFrom(CastVoteRequest castVoteRequest) {
        try {
            var foundUser = voterService.findVoter(castVoteRequest.getVoterId());
        } catch (NullPointerException ex) {
            throw new IllegalArgumentException(String.format("Citizen with id %s does not exist", castVoteRequest.getVoterId()));
        }
    }

    @Override
    public long count() {
        return voteRepository.countVote();
    }
    @Override
    public long eachPoliticalParty(String party) {
        return voteRepository.eachPartyVoteCount(party);
    }
}


