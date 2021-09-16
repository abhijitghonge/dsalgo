package com.ag.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibannaci {

    private final  Map<Integer, Integer> memoized = new HashMap<>();
    public static void main(String[] args) {
        Fibannaci fibo = new Fibannaci();

        System.out.println("30=>"+fibo.calculate(40));
        System.out.println("=======================================");

        System.out.println("30=>"+Fibannaci.fiboNoRecur(40));

    }

    private static int fiboNoRecur(int number){ //O(n)
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

    private  int calculate(int number) { //O(2^n) but here due memoization it is O(n)
        //read on Tail Call Optimization
        if(number == 0) return 0;
        if(number == 1 || number == 2) return 1;

        return memoized.computeIfAbsent(number, (num) ->
                calculate(num - 1) + calculate(num - 2));
    }
}
