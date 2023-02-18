package com.ag.arrays;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistance {
    public static void main(String[] args) {
        String A = "x....o.x...o";

        MinimumDistance minimumDistance = new MinimumDistance();
        System.out.println("minimum:"+minimumDistance.solve(A));
    }

    public int solve(String A) {
        char[] chr = A.toCharArray();
        List<Integer> indexesX = new ArrayList<>();
        List<Integer> indexesO = new ArrayList<>();

        for (int i = 0; i < chr.length - 1; i++) {
            if (chr[i] == 'x') {
                indexesX.add(i);
            }
            if (chr[i] == 'o') {
                indexesO.add(i);
            }
        }

        int minimum = Integer.MAX_VALUE;
        for (int indexX: indexesX) {
            for (int indexO: indexesO ) {
                int distance = Math.abs(indexX - indexO);

                if(distance < minimum){
                    minimum = distance;
                }
            }
        }


        return (minimum == Integer.MAX_VALUE)? -1:minimum;
    }

}
