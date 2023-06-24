package com.example.demo2.dtos.Requests;

import com.example.demo2.data.model.PoliticalParty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CastVoteRequest {
    private String username;
    private PoliticalParty politicalParty;
}
