package com.ag.lld.patterns.bridge.cards;

import com.ag.lld.patterns.bridge.CardDetails;
import com.ag.lld.patterns.bridge.PaymentMethod;
import com.ag.lld.patterns.bridge.PaymentProvider;
import com.ag.lld.patterns.bridge.cards.CreditPaymentMethod;
import com.ag.lld.patterns.bridge.cards.DebitPaymentMethod;
import com.ag.lld.patterns.bridge.cards.NetBankPaymentMethod;
import com.ag.lld.patterns.bridge.cards.PaymentMethodType;

import java.util.EnumMap;

public class PaypalPaymentProvider implements PaymentProvider {

    private EnumMap<PaymentMethodType, PaymentMethod> paymentMethodMap;

    public PaypalPaymentProvider(){
        paymentMethodMap = new EnumMap<>(PaymentMethodType.class);
        paymentMethodMap.put(PaymentMethodType.CREDIT, new CreditPaymentMethod());
        paymentMethodMap.put(PaymentMethodType.DEBIT, new DebitPaymentMethod());
        paymentMethodMap.put(PaymentMethodType.NETBANK, new NetBankPaymentMethod());
    }

    @Override
    public boolean processPayment(CardDetails cardDetails, double amount, PaymentMethodType paymentType) {
        System.out.println("PayPal processing payment for:");
        paymentMethodMap.get(paymentType).pay(cardDetails, amount);
        return false;
    }
}
