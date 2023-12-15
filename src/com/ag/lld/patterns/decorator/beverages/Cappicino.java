package com.ag.lld.patterns.decorator.beverages;

import com.ag.lld.patterns.decorator.Beverage;

public class Cappicino implements Beverage {
    @Override
    public Double calculateCost() {
        double cost = 215.00;
        System.out.printf("Cost of Cappicino:[%f]%n", cost);
        return cost;
    }
}
