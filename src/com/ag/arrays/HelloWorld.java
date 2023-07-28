package com.ag.arrays;

import java.util.Objects;

import static java.util.Objects.isNull;

public class HelloWorld {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        fun(arr);
        System.out.println(arr[3]);

    }

    static void fun(int[] arr){
        arr[3] = 98;
        return;
    }

    public static String reverse(String input){
        if(isNull(input)) return null;
        char[] inputChars = input.toCharArray();
        StringBuilder strBuilder = new StringBuilder();
        for (int count = inputChars.length -1; count >= 0; count --) {
            strBuilder.append(inputChars[count]);
        }

        return strBuilder.toString();
    }

    public static String reverse2(String input){

        StringBuilder stringBuilder = new StringBuilder(input);

        return stringBuilder.reverse().toString();
    }


}
