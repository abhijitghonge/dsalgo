package com.ag.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] input = {4,2,67,76,55,3};
        sort(input);
        Arrays.stream(input).forEach(System.out::println);

    }

    public static void sort(int[] input){
        int k = 0;
        while(k < input.length - 1){//O(n^2)
            for (int i = 0; i < input.length -k - 1; i++) {
                if(input[i]> input[i+1]){
                    //swap
                    int temp = input[i];
                    input[i] = input[i+1];
                    input[i+1] = temp;
                }
            }
            k++;
        }
    }
}
