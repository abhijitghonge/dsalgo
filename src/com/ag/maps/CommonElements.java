package com.ag.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CommonElements {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.

        Map<Integer, Integer> lookup = buildFreqMap(A);

        ArrayList<Integer> result = new ArrayList<>();

        for(Integer other : B){
            if(lookup.containsKey(other)){
                int freq = lookup.get(other);

                if(freq > 0){
                    result.add(other);
                }

                lookup.put(other, freq - 1);
            }
        }

        return result;
    }

    private Map<Integer, Integer> buildFreqMap(ArrayList<Integer> A){
        Map<Integer, Integer> lookup = new HashMap<>();

        for(int number: A){

            lookup.compute(number, (k,v)-> Objects.isNull(v)?1:v+1);

        }

        return lookup;
    }
}
