//package com.example.demo2.data.repository;
//
//import com.example.demo2.data.model.Voter;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class VoterRepositoryImpl implements VoterRepository {
//    private int count;
//    private List<Voter> voters = new ArrayList<>();
//
//    @Override
//    public Voter save(Voter voter) {
//        boolean voterHasNotBeenSaved = voter.getId() == 0;
//        if(voterHasNotBeenSaved){
//            voter.setId(generateVoterId());
//            voters.add(voter);
//            count++;
//        }
//        return voter;
//    }
//    private int generateVoterId() {
//        return count + 1;
//    }
//
//    @Override
//    public Voter findById(int id) {
//        for (Voter voter : voters) {
////            System.out.println(voter.getId());
//            if (voter.getId() == id) return voter;
//        }
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return count;
//    }
//
//    @Override
//    public List<Voter> findAll() {
//        return voters;
//    }
//
//    @Override
//    public void delete(Voter voter) {
//    }
//
//    @Override
//    public void delete(int id) {
////        for (int i = 0; i < voters.size(); i++) {
////            if (voters.get(i).getId() == id){
////                voters.remove(voters.get(i));
////                count--;
////                break;
////            }
////        }
////        todo => it is same as
//        for (Voter voter: voters){
//            if(voter.getId() == id){
//                voters.remove(voter);
//                count--;
//                break;
//            }
//        }
//    }
//
//    @Override
//    public void deleteAll() {
//        voters.clear();
//        count = 0;
//    }
//
//    @Override
//    public Voter findByUsername(String username) {
//        for(Voter voter: voters){
//            if(voter.getUsername().equalsIgnoreCase(username)) return voter;
//        }
//        return null;
//    }
//}
