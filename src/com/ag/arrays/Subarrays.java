package com.ag.arrays;

import java.util.ArrayList;

public class Subarrays {

    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {
        int size = A.size() * (A.size() + 1)/2;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(size);

        for (int i =0; i< A.size(); i++){
            ArrayList<Integer> traversals = new ArrayList<>();
            for (int j = i; j< A.size(); j++){
                traversals.add(A.get(j));
                ArrayList<Integer> subarrays = new ArrayList<>();
                for(int element: traversals){

                    subarrays.add(element);
                    matrix.add(subarrays);
                }
            }

        }

        return matrix;
    }
}
