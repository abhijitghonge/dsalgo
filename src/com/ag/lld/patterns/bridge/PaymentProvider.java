package com.ag.lld.patterns.bridge;

import com.ag.lld.patterns.bridge.cards.PaymentMethodType;

public interface PaymentProvider {
    boolean processPayment(CardDetails cardDetails, double amount, PaymentMethodType paymentType);
}
