package com.ag.lld.patterns.decorator.beverages;

import com.ag.lld.patterns.decorator.Beverage;

public class Expresso implements Beverage {
    @Override
    public Double calculateCost() {
        double cost = 150.00;
        System.out.printf("Cost of expresso:[%f]%n",cost );
        return cost;
    }
}
