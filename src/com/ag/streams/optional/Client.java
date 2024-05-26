package com.ag.streams.optional;

import java.util.Optional;

import static java.util.Optional.*;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        System.out.println(client.getDiscountLine(new Customer(new MemberCard(5))));
        System.out.println(client.getDiscountLine(new Customer(new MemberCard(70))));
        System.out.println(client.getDiscountLine(new Customer(null)));

    }

    public String getDiscountLine(Customer customer) {

        return customer.getCard()
                .flatMap(this::getDiscountPercentage)
                .map(discount ->"Discount: " + discount + "%" )
                .orElse("Discount: none");

    }

    private Optional<Integer> getDiscountPercentage(MemberCard card) {
        if(card.getFidilityPoints() >=100){
            return of(100);
        }else if (card.getFidilityPoints()>=10){
            return of(10);
        }

        return empty();
    }
}
