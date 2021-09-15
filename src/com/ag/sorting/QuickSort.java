package com.ag.sorting;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        Arrays.stream(sort(numbers)).forEach(System.out::println);
    }

    private static int[] sort(int[] numbers) {

        if(numbers.length ==0){
            return numbers;
        }
        //pick a pivot
        int length = numbers.length;
        int pivot = numbers.length -1;
//        System.out.println("Pivot:"+pivot);
        int index = 0;
        while (index < pivot){
            if(numbers[index] >= numbers[pivot] && (pivot - index) >=2) {
                //put greater number to index after pivot
                int temp = numbers[index];
                numbers[index] = numbers[pivot - 1];
                numbers[pivot - 1] = numbers[pivot];
                numbers[pivot] = temp;
                pivot--;
            }else if(numbers[index] >= numbers[pivot] && (pivot - index) < 2){
                int temp = numbers[index];
                numbers[index] = numbers[pivot];
                numbers[pivot] = temp;
                pivot--;
            }else {
                //move the index to next in array
                index++;
            }
        }

//        System.out.println("pivot after:"+pivot);

//        printArrays("After Numbers:",numbers);

        //exit condition
        if(numbers.length <= 2){
            return numbers;
        }

        //pivot is at right index in array, split left and right
        int[] left = new int[pivot];
        System.arraycopy(numbers, 0, left, 0, pivot);
//        printArrays("left",left);


        int[] right = new int[length - pivot - 1];
        System.arraycopy(numbers, pivot+1, right, 0, length - pivot - 1);
//        printArrays("right",right);

        return merge(sort(left),numbers[pivot], sort(right));
    }

    private static void printArrays(String name, int[] numbers) {
        System.out.print(name+":[");
        Arrays.stream(numbers).forEach((number) ->{
            System.out.print(number+" ");
        });
        System.out.println("]");
    }

    private static int[] merge(int[] left,int pivotValue, int[] right) {
        int[] merged = new int[left.length+ right.length+1];

        System.arraycopy(left, 0, merged, 0, left.length);
        merged[left.length] = pivotValue;
        System.arraycopy(right, 0, merged, left.length+1, right.length);

        return merged;
    }
}
