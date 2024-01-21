package com.ag.lld.parkinglot.dtos;

import com.ag.lld.parkinglot.model.Bill;
import com.ag.lld.parkinglot.model.enums.ResponseStatus;

public class GenerateBillResponseDto {
    private Bill bill;
    private ResponseStatus status;
    private String failureMessage;

    private GenerateBillResponseDto(Bill bill, ResponseStatus status, String failureMessage){
        this.bill = bill;
        this.failureMessage = failureMessage;
        this.status = status;
    }

    public static GenerateBillResponseBuilder builder(){
        return new GenerateBillResponseBuilder();
    }

    public static class GenerateBillResponseBuilder {
        private Bill bill;
        private ResponseStatus status;
        private String failureMessage;

        public GenerateBillResponseBuilder setBill(Bill bill) {
            this.bill = bill;
            return this;
        }

        public GenerateBillResponseBuilder setStatus(ResponseStatus status) {
            this.status = status;
            return this;
        }

        public GenerateBillResponseBuilder setFailureMessage(String failureMessage) {
            this.failureMessage = failureMessage;
            return this;
        }

        public GenerateBillResponseDto build(){
            return new GenerateBillResponseDto(bill, status,failureMessage );
        }
    }
}
