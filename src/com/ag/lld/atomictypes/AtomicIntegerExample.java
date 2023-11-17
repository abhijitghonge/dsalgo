package com.ag.lld.atomictypes;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) {
        // Create an AtomicInteger with an initial value of 0
        AtomicInteger atomicInt = new AtomicInteger(0);

        // Increment the AtomicInteger
        int incrementedValue = atomicInt.incrementAndGet();
        System.out.println("Incremented Value: " + incrementedValue);

        // Decrement the AtomicInteger
        int decrementedValue = atomicInt.decrementAndGet();
        System.out.println("Decremented Value: " + decrementedValue);

        // Add a specific value to the AtomicInteger
        atomicInt.addAndGet(5);
        System.out.println("After adding 5: " + atomicInt.get());

        // Get the current value of the AtomicInteger
        int currentValue = atomicInt.get();
        System.out.println("Current Value: " + currentValue);

        // Set a new value for the AtomicInteger
        atomicInt.set(10);
        System.out.println("New Value: " + atomicInt.get());
    }
}
