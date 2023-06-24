package com.example.demo2.data.repository;

import com.example.demo2.data.model.PoliticalParty;
import com.example.demo2.data.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
//    Vote save(Vote vote) ;

    Vote findByUsername(String username);
    Vote findByPoliticalParty(PoliticalParty politicalParty);
//    long countVote();
//    long eachPartyVoteCount(String party);
//    List<Vote> findAll();
//    void delete(Vote vote);
//    void delete(int id);
    void deleteAll();
    long countByPoliticalParty(PoliticalParty politicalParty);
}

