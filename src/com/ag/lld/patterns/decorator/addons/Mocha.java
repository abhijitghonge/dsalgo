package com.ag.lld.patterns.decorator.addons;

import com.ag.lld.patterns.decorator.Beverage;

public class Mocha implements Beverage {
    private Beverage original;
    public Mocha(Beverage original){
        this.original = original;
    }
    @Override
    public Double calculateCost() {
        double mochaCost = 50.00;
        System.out.printf("Mocha cost:[%f] ", mochaCost);

        return mochaCost+original.calculateCost();
    }
}
