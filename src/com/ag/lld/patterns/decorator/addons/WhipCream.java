package com.ag.lld.patterns.decorator.addons;

import com.ag.lld.patterns.decorator.Beverage;

public class WhipCream implements Beverage {
    private Beverage original;
    public WhipCream(Beverage original){
        this.original = original;
    }
    @Override
    public Double calculateCost() {
        double whipCost = 10.00;
        System.out.printf("WhipCream cost:[%f] ", whipCost);

        return whipCost+original.calculateCost();
    }
}
