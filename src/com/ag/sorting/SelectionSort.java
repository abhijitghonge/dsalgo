package com.ag.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        sort(numbers);
        Arrays.stream(numbers).forEach(System.out::println);
    }

    public static void sort(int[] numbers){
        for (int k = 0; k < numbers.length - 1; k++) {//O(n^2)
            int smallestIndex = k;
            for (int i = k+1; i < numbers.length; i++) {
                if(numbers[smallestIndex] > numbers[i]){
                    smallestIndex = i;
                }
            }
            //swap with smallest position
            int temp = numbers[smallestIndex];
            numbers[smallestIndex] = numbers[k];
            numbers[k] = temp;

        }

    }
}
