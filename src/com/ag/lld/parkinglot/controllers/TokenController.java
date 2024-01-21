package com.ag.lld.parkinglot.controllers;

import com.ag.lld.parkinglot.dtos.IssueTokenRequestDto;
import com.ag.lld.parkinglot.dtos.IssueTokenResponseDto;
import com.ag.lld.parkinglot.exceptions.InvalidTokenException;
import com.ag.lld.parkinglot.model.Token;
import com.ag.lld.parkinglot.model.enums.ResponseStatus;
import com.ag.lld.parkinglot.services.TokenService;

public class TokenController {

    private TokenService tokenService;

    public TokenController(TokenService tokenService){
        this.tokenService = tokenService;
    }
    public IssueTokenResponseDto issueToken(IssueTokenRequestDto request){
        IssueTokenResponseDto responseDto = new IssueTokenResponseDto();
        try{
            Token token = tokenService.issueToken(request.getVehicleNumber(),request.getGateId(), request.getVehicleType());
            responseDto.setToken(token);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);

        }catch(InvalidTokenException ite){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setFailureMessage(ite.getMessage());

        }

        return responseDto;

    }
}
