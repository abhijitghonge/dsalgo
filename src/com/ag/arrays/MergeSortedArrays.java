package com.ag.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] array1 = {0,3,4};
        int[] array2 = {4,6,30};

        int[] result = mergeSortedArrays(array1,array2 );
        Arrays.stream(result).forEach(System.out::println);

    }

    public static int[] mergeSortedArrays(int[] array1, int[] array2){
        if(array1.length == 0) return array2;
        if(array2.length == 0 ) return array1;

        int[] result = new int[array1.length+array2.length];
        int count1 = 0;
        int count2 = 0;
        int count = 0;
        while(count1 < array1.length && count2 < array2.length){
            if(array1[count1] <= array2[count2]){
                result[count] = array1[count1];
                count++;
                count1++;
            }else{
                result[count] = array2[count2];
                count++;
                count2++;
            }
        }

        while(count1 < array1.length){
            result[count] = array1[count1];
            count++;count1++;
        }

        while(count2 < array2.length){
            result[count] = array2[count2];
            count++;count2++;
        }
        return result;
    }
}
