package com.ag.lld.patterns.adapter.banks.icici;

public class ICICIBankAPI {

    public double balance() {
        return 10101.01;
    }

    public boolean doTransfer(double amount, int from, int to) {
        System.out.printf("Amount %.2f transferred in ICICI Bank from: %d to %d%n", amount, from, to);
        return true;
    }
}
