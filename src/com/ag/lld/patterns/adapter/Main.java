package com.ag.lld.patterns.adapter;

public class Main {
    public static void main(String[] args) {
        APIAdapterFactory factory = new APIAdapterFactory();
        BankAPI bankAPI = factory.getBankAPI(BankType.ICICI);

        bankAPI.checkBalance();
        bankAPI.transfer(100, 1011, 1023);

        bankAPI = factory.getBankAPI(BankType.HDFCBANK);

        bankAPI.checkBalance();
        bankAPI.transfer(100, 1011, 1025);


    }

}
