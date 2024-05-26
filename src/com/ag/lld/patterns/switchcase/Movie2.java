package com.ag.lld.patterns.switchcase;

public class Movie2 {


    public int computePrice(int days,PriceService priceService,  MovieType movieType ) {
        return movieType.getPriceAlgo().apply(priceService, days);
    }
}
