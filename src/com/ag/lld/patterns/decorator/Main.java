package com.ag.lld.patterns.decorator;

import com.ag.lld.patterns.decorator.addons.Mocha;
import com.ag.lld.patterns.decorator.addons.WhipCream;
import com.ag.lld.patterns.decorator.beverages.Cappicino;
import com.ag.lld.patterns.decorator.beverages.Expresso;

public class Main {
    public static void main(String[] args) {
        Beverage coffee = new Expresso();
        //Expresso with Whip Cream
        coffee = new WhipCream(coffee);

        coffee.calculateCost();

        //Cappicuno with Mocha
        Beverage cappicinoWithMocha = new Mocha(new Cappicino());

        cappicinoWithMocha.calculateCost();


    }
}
