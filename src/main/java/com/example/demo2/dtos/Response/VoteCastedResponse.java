package com.example.demo2.dtos.Response;

import com.example.demo2.data.model.PoliticalParty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class VoteCastedResponse {
    private String username;
    private PoliticalParty party;
}



