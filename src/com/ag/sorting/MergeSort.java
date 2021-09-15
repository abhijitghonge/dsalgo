package com.ag.sorting;

import com.ag.arrays.MergeSortedArrays;

import java.util.Arrays;

import static java.lang.System.arraycopy;

public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        Arrays.stream(sort(numbers)).forEach(System.out::println);
    }

    private static int[] sort(int[] numbers) {//O(nlogn)
        if(numbers.length ==1){
            return numbers;
        }
        //split the array into left and right
        int mid = numbers.length / 2;
        int[] left = new int[mid];
        arraycopy(numbers, 0, left, 0, mid);

        int rightlength = numbers.length - mid;
        int[] right = new int[rightlength];
        arraycopy(numbers, mid, right, 0,rightlength);

        return MergeSortedArrays.mergeSortedArrays(sort(left), sort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        //merge the sorted arrays
        return MergeSortedArrays.mergeSortedArrays(left, right);
    }
}
