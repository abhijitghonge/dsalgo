package com.ag.lld.patterns.switchcase;

public class PriceService {


    public int computeRegularPrice(int days) {
        return days * 30;
    }

    public int computeNewReleasePrice(int days) {
        return days * 60;
    }

    public int computeChildren(int days) {
        return days * 7;
    }

}
