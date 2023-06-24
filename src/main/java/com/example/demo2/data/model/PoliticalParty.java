package com.example.demo2.data.model;

public enum PoliticalParty {
    APC("APC"),
    PDP("PDP"),
    LP("LP"),
    NNPP("NNPP"),
    AA("AA");

    private final String party;

    PoliticalParty(String party) {
        this.party = party;
    }

    public String getFillCell() {
        return party;
    }
}
