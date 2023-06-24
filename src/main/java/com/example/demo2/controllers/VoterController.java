package com.example.demo2.controllers;

import com.example.demo2.dtos.Requests.RegisterRequest;
import com.example.demo2.dtos.Response.FindVoterResponse;
import com.example.demo2.exceptions.UserRegistrationFailedException;
import com.example.demo2.exceptions.VoteEligibilityException;
import com.example.demo2.services.VoterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class VoterController {
    private final VoterService voterService;

    @PostMapping("/voter/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
             FindVoterResponse response = voterService.register(request);
             return ResponseEntity.ok(response);
        } catch (UserRegistrationFailedException | VoteEligibilityException e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/voter/{id}")
    public Object findVoterById(@PathVariable Long id) {
        try{
            return voterService.findVoter(id);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        try {
            var response = voterService.deleteById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
