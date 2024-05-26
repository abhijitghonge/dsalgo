package com.ag.lld.patterns.switchcase;

import java.util.function.BiFunction;
import java.util.function.Function;

public enum MovieType {
    REGULAR(PriceService::computeRegularPrice),
    NEW_RELEASE(PriceService::computeNewReleasePrice),
    CHILDREN(PriceService::computeChildren);



    private BiFunction<PriceService, Integer, Integer> priceAlgo;

    MovieType(BiFunction<PriceService, Integer, Integer> priceAlgo) {
        this.priceAlgo = priceAlgo;
    }

    public BiFunction<PriceService, Integer, Integer> getPriceAlgo() {
        return priceAlgo;
    }
}
