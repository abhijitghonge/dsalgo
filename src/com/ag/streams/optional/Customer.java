package com.ag.streams.optional;

import java.util.Optional;

public class Customer {

    private MemberCard card;

    public Customer(MemberCard card) {
        this.card = card;
    }


    public Optional<MemberCard> getCard() {
        return Optional.ofNullable(card);
    }
}
