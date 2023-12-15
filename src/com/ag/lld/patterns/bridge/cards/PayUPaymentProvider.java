package com.ag.lld.patterns.bridge.cards;

import com.ag.lld.patterns.bridge.CardDetails;
import com.ag.lld.patterns.bridge.PaymentMethod;
import com.ag.lld.patterns.bridge.PaymentProvider;

import java.util.EnumMap;

public class PayUPaymentProvider implements PaymentProvider {

    private EnumMap<PaymentMethodType, PaymentMethod> paymentMethodMap;

    public PayUPaymentProvider(){
        paymentMethodMap = new EnumMap<>(PaymentMethodType.class);
        paymentMethodMap.put(PaymentMethodType.CREDIT, new CreditPaymentMethod());
        paymentMethodMap.put(PaymentMethodType.DEBIT, new DebitPaymentMethod());
    }

    @Override
    public boolean processPayment(CardDetails cardDetails, double amount, PaymentMethodType paymentType) {
        System.out.println("PayU India processing payment for:");
        if(!paymentMethodMap.containsKey(paymentType)) {
            System.out.println("[%s] payment method not supported! Please try other methods!!");
            return false;
        }
        return paymentMethodMap.get(paymentType).pay(cardDetails, amount);

    }
}
