//package com.example.demo2.data.repository;
//
//import com.example.demo2.data.model.Vote;
//import com.example.demo2.data.model.PoliticalParty;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class VoteRepositoryImpl implements VoteRepository {
//    private int countVote;
//    private int eachPartyVoteCount;
//    private List<Vote> votes = new ArrayList<>();
//
//    @Override
//    public Vote save(Vote vote) {
//        boolean voteHasNotBeenSaved = vote.getId() == 0;
//        if (voteHasNotBeenSaved) {
//            vote.setId(generateVoteId());
//            votes.add(vote);
//            countVote++;
//        }
//        return vote;
//    }
//
//    private int generateVoteId() {
//        return countVote + 1;
//    }
////public int candidateVote(){
////        if()
////}
//
//    @Override
//    public Vote findById(int id) {
//        for (Vote vote : votes) if (vote.getId() == id) return vote;
//        return null;
//    }
//
//    @Override
//    public Vote findByPartyName(String party) {
//        for (Vote vote : votes)
//            if (vote.getParty().equalsIgnoreCase(party))
//                return vote;
//        return null;
//    }
//
//    @Override
//    public long countVote() {
//        return countVote;
//    }
//
//    private void findAndCountPartyVote(String party) {
//        for (Vote vote : votes) {
//            if (vote.getParty().equalsIgnoreCase(PoliticalParty.APC.getFillCell())) eachPartyVoteCount++;
//        }
//    }
//
//    @Override
//    public long eachPartyVoteCount(String party) {
//        findAndCountPartyVote(party);
//        return eachPartyVoteCount;
//    }
//
//    @Override
//    public List<Vote> findAll() {
//        return null;
//    }
//
//    @Override
//    public void delete(Vote vote) {
//
//    }
//
//    @Override
//    public void delete(int id) {
//        for (Vote vote : votes) {
//            if (vote.getParty().equalsIgnoreCase(String.valueOf(vote))) {
//                votes.remove(vote);
//                countVote--;
//                break;
//            }
//        }
//    }
//
//    @Override
//    public void deleteAll() {
//        votes.clear();
//        countVote = 0;
//    }
//}
