package com.ag.dp;

import java.util.PriorityQueue;
import java.util.Queue;

public class Knapsack {

    private class Item {
        public int value;
        int weight;
        double perUnitVal;

        Item(int value, int weight, double perUnitVal) {
            this.value = value;
            this.weight = weight;
            this.perUnitVal = perUnitVal;
        }
    }

    public int solve(int[] A, int[] B, int C) {
        Queue<Item> items = new PriorityQueue<>((i1, i2) -> Double.compare(i2.perUnitVal, i1.perUnitVal));

        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            int weight = B[i];
            double perUnitVal = (double) A[i] / B[i];
            items.offer(new Item(value, weight, perUnitVal));
        }

        int capacity = C;
        int totalValue = 0;
        while (capacity > 0 && !items.isEmpty()) {
            Item item = items.poll();
            int weight = Math.min(capacity, item.weight);
            totalValue += (int) item.perUnitVal * weight * 100;
            capacity -= weight;
        }

        return totalValue;
    }
}

