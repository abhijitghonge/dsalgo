package com.ag.lld.parkinglot.dtos;

public class GenerateBillRequestDto {
    private String tokenNumber;
    private Long gateId;

    public String getTokenNumber() {
        return tokenNumber;
    }

    public void setTokenId(String tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }
}
