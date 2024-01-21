package com.ag.lld.parkinglot.dtos;

import com.ag.lld.parkinglot.model.Token;
import com.ag.lld.parkinglot.model.enums.ResponseStatus;

public class IssueTokenResponseDto {

    private Token token;
    private ResponseStatus responseStatus;
    private String failureMessage;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }
}
