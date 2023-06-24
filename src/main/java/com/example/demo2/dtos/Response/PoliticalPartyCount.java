package com.example.demo2.dtos.Response;

import com.example.demo2.data.model.PoliticalParty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PoliticalPartyCount {
    private long totalCount;
    private PoliticalParty party;
}
