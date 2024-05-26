package com.ag.lld.patterns.switchcase;

public class Movie {

    enum Type {
        REGULAR, NEW_RELEASE, CHILDREN
    }

    private final Type type;

    public Movie(Type type) {
        this.type = type;
    }


    public int computePrice(int days) {
        // Always have this here!
        return switch (type) {
            case REGULAR -> days + 1;
            case NEW_RELEASE -> days * 2;
            case CHILDREN -> 5;
            default -> throw new IllegalArgumentException(); // Always have this here!
        };

    }

}