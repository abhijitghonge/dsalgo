package com.ag.math;

import java.util.Scanner;

public class HighestCommonFactor {
    public static void main(String[] args) {
        HighestCommonFactor hcf = new HighestCommonFactor();
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B= sc.nextInt();
        System.out.printf("hcf:%d", hcf.compute(A,B));
    }

    private int compute(int A, int B){
        if(A==0) return B;
        if(B>A){
            return compute(B,A);
        }else {
            return compute(A - B, B);
        }
    }
}
