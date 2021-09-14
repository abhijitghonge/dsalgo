package com.ag.recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(Factorial.of(5));
        System.out.println(Factorial.ofNonRecursive(5));

    }

    public static int of(int number){
        if(number == 1) return 1;
        return number * of(number - 1);
    }

    public static int ofNonRecursive(int number){
        int factorial = 1;
        for (int i = 2; i <= number ; i++) {
            factorial = factorial * i;
        }

        return factorial;
    }
}
