package com.example.demo.dtos.Response;

import java.util.PrimitiveIterator;

public class VoteCastedResponse {
//    private int id;
    private long totalCount;
    private String party;

    @Override
    public String toString() {
        return "VoteCastedResponse{" +
                ", totalCount=" + totalCount +
                ", party='" + party + '\'' +
                '}';
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }
}



