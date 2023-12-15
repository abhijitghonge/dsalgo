package com.ag.lld.patterns.bridge;

import com.ag.lld.patterns.bridge.cards.CardType;

public class CardDetails {


    private CardType cardType;
    private String expiryDate;
    private int CVV;
    private String cardNumber;

    private CardDetails(CardType cardType, String expiryDate, int CVV, String cardNumber) {
        this.cardType = cardType;
        this.expiryDate = expiryDate;
        this.CVV = CVV;
        this.cardNumber = cardNumber;
    }


    public static CardDetailsBuilder builder(){
        return new CardDetailsBuilder();
    }

    @Override
    public String toString() {
        return "CardDetails{" +
                "cardType=" + cardType +
                ", expiryDate='" + expiryDate + '\'' +
                ", CVV=" + CVV +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }

    public static class CardDetailsBuilder {

        private CardType cardType;
        private String expiryDate;
        private int CVV;
        private String cardNumber;

        public CardDetailsBuilder setCardType(CardType cardType) {
            this.cardType = cardType;
            return this;
        }

        public CardDetailsBuilder setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
            return  this;
        }

        public CardDetailsBuilder setCVV(int CVV) {
            this.CVV = CVV;
            return this;
        }

        public CardDetailsBuilder setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public CardDetails build(){
            return new CardDetails(this.cardType, this.expiryDate, this.CVV, this.cardNumber);
        }
    }
}
