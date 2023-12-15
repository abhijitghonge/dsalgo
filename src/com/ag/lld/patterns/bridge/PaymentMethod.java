package com.ag.lld.patterns.bridge;

public interface PaymentMethod {
    boolean pay(CardDetails cardDetails, double amount);
}
