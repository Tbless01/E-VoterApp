package com.example.demo2.services;

import com.example.demo2.data.model.PoliticalParty;
import com.example.demo2.data.model.Vote;
import com.example.demo2.data.repository.VoteRepository;
import com.example.demo2.dtos.Requests.CastVoteRequest;
import com.example.demo2.dtos.Response.FindVoterResponse;
import com.example.demo2.dtos.Response.PoliticalPartyCount;
import com.example.demo2.dtos.Response.VoteCastedResponse;
import com.example.demo2.exceptions.UserHasVotedException;
import com.example.demo2.exceptions.UserNotFoundException;
import com.example.demo2.exceptions.VoteAvailablePartyException;
import com.example.demo2.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class VoteServiceImpl implements VoteService {


    private final VoteRepository voteRepository;
    private final VoterService voterService;

    @Override
    public VoteCastedResponse castVote(CastVoteRequest castVoteRequest) throws UserNotFoundException, UserHasVotedException, VoteAvailablePartyException {
        checkIfUserExists(castVoteRequest);
        checkIfCitizenHasVoted(castVoteRequest);
        Vote vote = checkIfCitizenVotedForAvailableParties(castVoteRequest);
        Mapper.map(castVoteRequest, vote);
        return Mapper.mapp(voteRepository.save(vote));
    }

    private void checkIfCitizenHasVoted(CastVoteRequest castVoteRequest) throws UserHasVotedException, VoteAvailablePartyException {
        if (voteRepository.findByUsername(castVoteRequest.getUsername()) != null)
            throw new UserHasVotedException(String.format("Citizen with username %s has already voted. %n One citizen is not allowed to vote twice.",castVoteRequest.getUsername()));
    }

    private Vote checkIfCitizenVotedForAvailableParties(CastVoteRequest castVoteRequest) throws VoteAvailablePartyException {
        if (castVoteRequest.getPoliticalParty().name().equalsIgnoreCase(PoliticalParty.APC.getFillCell()) || castVoteRequest.getPoliticalParty().getFillCell().equalsIgnoreCase(PoliticalParty.PDP.getFillCell()) || castVoteRequest.getPoliticalParty().name().equalsIgnoreCase(PoliticalParty.LP.getFillCell()) || castVoteRequest.getPoliticalParty().getFillCell().equalsIgnoreCase(PoliticalParty.NNPP.getFillCell()) || castVoteRequest.getPoliticalParty().getFillCell().equalsIgnoreCase(PoliticalParty.AA.getFillCell())) {
            Vote vote = new Vote();
            return vote;
        }
        throw new VoteAvailablePartyException("There is no such party. Vote for one of the available parties.");
    }

    public Optional<Vote> findVoteById(Long id) {
        Optional<Vote> vote = voteRepository.findById(id);
        if (vote.isEmpty()) throw new IllegalArgumentException("Citizen has not casted a vote");
        return vote;
    }

    @Override
    public List<FindVoterResponse> findAll() {
        return null;
    }

    @Override
    public PoliticalPartyCount voteCountForParty(PoliticalParty politicalParty) {
        PoliticalPartyCount politicalPartyCount = new PoliticalPartyCount();
        politicalPartyCount.setParty(politicalParty);
        politicalPartyCount.setTotalCount(voteRepository.countByPoliticalParty(politicalParty));
        return politicalPartyCount;
    }

    private void checkIfUserExists(CastVoteRequest castVoteRequest) throws UserNotFoundException {
        try {
            voterService.findVoterByUsername(castVoteRequest.getUsername());
        } catch (UserNotFoundException | NullPointerException e) {
            throw new UserNotFoundException(String.format("User with username %s does not exist ", castVoteRequest.getUsername()));
        }
    }
}





