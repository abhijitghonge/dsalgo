package com.ag.lld.patterns.adapter.banks.icici;

import com.ag.lld.patterns.adapter.BankAPI;

public class ICICIBankAPIAdapter implements BankAPI {

    private ICICIBankAPI bankHandle = new ICICIBankAPI();

    @Override
    public Double checkBalance() {
        return bankHandle.balance();
    }

    @Override
    public boolean transfer(double amount, int from, int to) {

        return bankHandle.doTransfer(amount,from, to);
    }
}
