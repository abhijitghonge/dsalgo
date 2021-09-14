package com.ag.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibannaci {

    private final static Map<Integer, Integer> memoized = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("0=>"+Fibannaci.fibo(0));
        System.out.println("1=>"+Fibannaci.fibo(1));
        System.out.println("2=>"+Fibannaci.fibo(2));
        System.out.println("3=>"+Fibannaci.fibo(3));
        System.out.println("4=>"+Fibannaci.fibo(4));
        System.out.println("5=>"+Fibannaci.fibo(5));
        System.out.println("6=>"+Fibannaci.fibo(6));
        System.out.println("7=>"+Fibannaci.fibo(7));
        System.out.println("8=>"+Fibannaci.fibo(8));
        System.out.println("30=>"+Fibannaci.fibo(30));
        System.out.println("=======================================");

        System.out.println("0=>"+Fibannaci.fiboNoRecur(0));
        System.out.println("1=>"+Fibannaci.fiboNoRecur(1));
        System.out.println("2=>"+Fibannaci.fiboNoRecur(2));
        System.out.println("3=>"+Fibannaci.fiboNoRecur(3));
        System.out.println("4=>"+Fibannaci.fiboNoRecur(4));
        System.out.println("5=>"+Fibannaci.fiboNoRecur(5));
        System.out.println("6=>"+Fibannaci.fiboNoRecur(6));
        System.out.println("7=>"+Fibannaci.fiboNoRecur(7));
        System.out.println("8=>"+Fibannaci.fiboNoRecur(8));
        System.out.println("30=>"+Fibannaci.fiboNoRecur(30));



    }

    private static int fiboNoRecur(int number){
        if(number == 0) return 0;
        if(number == 1 || number == 2) return 1;
        int resultn1 = 1;
        int resultn2 = 1;
        int result = 0;
        for (int i = 3; i <= number; i++) {
            result = resultn1+resultn2;
            resultn1 = resultn2;
            resultn2 = result;
        }

        return result;
    }

    private static int fibo(int number) {
        if(number == 0) return 0;
        if(number == 1 || number == 2) return 1;

        return memoized.computeIfAbsent(number, (num) -> fibo(num - 1) + fibo(num - 2));
    }
}
