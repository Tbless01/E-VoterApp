package com.example.demo2.data.repository;

import com.example.demo2.data.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {
//    Voter save(Voter voter) ;
//    Voter findById(int id);
//    long count();
//    List<Voter> findAll();
//    void delete(Voter voter);
//    void delete(int id);
//    void deleteAll();
    Voter findByUsername(String username);
}
