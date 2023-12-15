package com.ag.lld.patterns.adapter;

public interface BankAPI {
    Double checkBalance();

    boolean transfer(double amount, int from, int to);
}
