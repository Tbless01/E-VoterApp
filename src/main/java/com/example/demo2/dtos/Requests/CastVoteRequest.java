package com.example.demo.dtos.Requests;

public class CastVoteRequest {
private String politicalParty;
private int voterId;

    @Override
    public String toString() {
        return "CastVoteRequest{" +
                "politicalParty='" + politicalParty + '\'' +
                ", voterId=" + voterId +
                '}';
    }

    public String getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(String politicalParty) {
        this.politicalParty = politicalParty;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }
}
