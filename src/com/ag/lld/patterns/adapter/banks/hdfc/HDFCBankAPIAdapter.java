package com.ag.lld.patterns.adapter.banks.hdfc;

import com.ag.lld.patterns.adapter.BankAPI;

public class HDFCBankAPIAdapter implements BankAPI {

    private HDFCBankExternalAPI hdfc3rdPartyAPI;

    public HDFCBankAPIAdapter(){
        hdfc3rdPartyAPI = new HDFCBankExternalAPI();
    }

    @Override
    public Double checkBalance() {
        return hdfc3rdPartyAPI.getBalance();
    }

    @Override
    public boolean transfer(double amount, int from, int to) {

        return hdfc3rdPartyAPI.doNeft(amount, from, to);
    }
}
