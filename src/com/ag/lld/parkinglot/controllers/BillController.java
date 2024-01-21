package com.ag.lld.parkinglot.controllers;

import com.ag.lld.parkinglot.dtos.GenerateBillRequestDto;
import com.ag.lld.parkinglot.dtos.GenerateBillResponseDto;
import com.ag.lld.parkinglot.exceptions.InvalidBillException;
import com.ag.lld.parkinglot.model.Bill;
import com.ag.lld.parkinglot.model.Token;
import com.ag.lld.parkinglot.model.enums.ResponseStatus;
import com.ag.lld.parkinglot.services.BillingService;

public class BillController {

    private final BillingService billingService;

    public BillController(BillingService billingService){
        this.billingService = billingService;
    }

    public GenerateBillResponseDto generateBill(GenerateBillRequestDto requestDto){
        GenerateBillResponseDto.GenerateBillResponseBuilder billResponseBuilder = GenerateBillResponseDto.builder();
        try{
            Bill bill = billingService.generateBill(requestDto.getTokenNumber(), requestDto.getGateId());
            billResponseBuilder.setBill(bill)
                    .setStatus(ResponseStatus.SUCCESS);
        }catch (InvalidBillException ibe){
            billResponseBuilder.setStatus(ResponseStatus.FAILURE)
                    .setFailureMessage(ibe.getMessage());
        }

        return billResponseBuilder.build();

    }
}
