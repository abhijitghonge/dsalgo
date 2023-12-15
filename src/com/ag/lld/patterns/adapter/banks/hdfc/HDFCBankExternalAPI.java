package com.ag.lld.patterns.adapter.banks.hdfc;

public class HDFCBankExternalAPI {

    public Double getBalance(){
        return 101123.12;
    }

    public boolean doNeft(double amount, int from , int to){
        System.out.printf("Amount %.2f transferred in HDFC Bank from: %d to %d%n", amount, from, to);
        return true;
    }
}
