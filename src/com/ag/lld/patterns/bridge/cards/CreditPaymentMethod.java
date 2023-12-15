package com.ag.lld.patterns.bridge.cards;

import com.ag.lld.patterns.bridge.CardDetails;
import com.ag.lld.patterns.bridge.PaymentMethod;

public class CreditPaymentMethod implements PaymentMethod {
    @Override
    public boolean pay(CardDetails cardDetails, double amount) {
        System.out.printf("Processing Credit Card:[%s] for amount [%f]%n", cardDetails.toString(), amount);
        return true;
    }
}
