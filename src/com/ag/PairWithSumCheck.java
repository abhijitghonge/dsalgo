package com.ag;

import java.util.HashSet;
import java.util.Set;

public class PairWithSumCheck {
    private final int expectedSum;

    public PairWithSumCheck(int expectedSum) {
        this.expectedSum = expectedSum;
    }

    public static void main(String[] args) {
        int[] array1 = {1,3,6,9};
        int[] array2 = {1,3,4,4};

        int expectedSum = 8;

        PairWithSumCheck check = new PairWithSumCheck(expectedSum);
        System.out.println(check.hasPairWithSum(array1));
        System.out.println(check.hasPairWithSum(array2));
    }

    private boolean hasPairWithSum(int[] array1) {

        Set<Integer> lookUpComplement = new HashSet<>();
        for (int value: array1){
            if(lookUpComplement.contains(value)) return true;
            lookUpComplement.add(expectedSum - value);
        }
        return false;
    }
}
