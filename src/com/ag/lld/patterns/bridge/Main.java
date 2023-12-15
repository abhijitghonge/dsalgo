package com.ag.lld.patterns.bridge;

import com.ag.lld.patterns.bridge.cards.CardType;
import com.ag.lld.patterns.bridge.cards.PayUPaymentProvider;
import com.ag.lld.patterns.bridge.cards.PaymentMethodType;
import com.ag.lld.patterns.bridge.cards.PaypalPaymentProvider;

public class Main {
    public static void main(String[] args) {
        PaymentProvider paypal = new PaypalPaymentProvider();

        CardDetails creditDetails = CardDetails.builder().setCardType(CardType.VISA)
                .setExpiryDate("12/25")
                .setCVV(654)
                .setCardNumber("234567890").build();

        paypal.processPayment(creditDetails, 2654.30, PaymentMethodType.CREDIT);

        PaymentProvider payU = new PayUPaymentProvider();

        payU.processPayment(creditDetails, 6785.34, PaymentMethodType.DEBIT);
    }
}
