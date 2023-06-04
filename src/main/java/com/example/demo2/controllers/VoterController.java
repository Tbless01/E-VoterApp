package com.example.demo.controllers;

import com.example.demo.dtos.Requests.RegisterRequest;
import com.example.demo.services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoterController {
    @Autowired
    private VoterService voterService;

    @PostMapping("/voter/register")
    public Object register(@RequestBody RegisterRequest request) {
        try {
            return voterService.register(request);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/voter/{id}")
    public Object findVoterById(@PathVariable int id) {
        try{
            return voterService.findVoter(id);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }
}
