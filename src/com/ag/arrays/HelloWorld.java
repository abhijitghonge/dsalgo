package com.ag.arrays;

import java.util.Objects;

import static java.util.Objects.isNull;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");

        System.out.println(Math.pow(6,1000000));

        int[] array = new int[]{1,2,3,4,5,5,6,6};
        System.out.println(array.length);
        System.out.println(reverse(null));
        System.out.println(reverse2("Hi, my name is Abhijit"));

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
