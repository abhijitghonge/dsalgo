package com.ag.arrays;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PickFromBothSides {

    public static void main(String[] args) {
        PickFromBothSides pickSum = new PickFromBothSides();

        Integer[] numbers = {2,3,-1,4,2,1};
        int B = 4;
        ArrayList<Integer> A = Stream.of(numbers).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(pickSum.solve(A, B));
    }

    public int solve(ArrayList<Integer> A, int B) {
        //create prefixes for start
        ArrayList<Integer> sumsStart =  buildPrefixSumStart(A,B);
        ArrayList<Integer> sumsEnd = buildPrefixSumEnd(A,B);

        int maxSum = Integer.MIN_VALUE;
        for( int i=0 ; i < sumsStart.size(); i++ ){
            int possibleSum = sumsStart.get(i) + sumsEnd.get(sumsStart.size() - i - 1);

            if(maxSum < possibleSum){
                maxSum = possibleSum;
            }
        }

        return maxSum;
    }

    private ArrayList<Integer>  buildPrefixSumStart(ArrayList<Integer> A, int B){
        ArrayList<Integer> sumsStart = new ArrayList<>();
        sumsStart.add(0); //possibility of 0 selection from start

        sumsStart.add(A.get(0)); // for first element

        for(int i = 1; i < B ; i++){
            int prefixSum = sumsStart.get(i) + A.get(i);
            sumsStart.add(prefixSum);
        }

        return sumsStart;
    }

    private ArrayList<Integer> buildPrefixSumEnd(ArrayList<Integer> A, int B){
        ArrayList<Integer> sumsEnd = new ArrayList<>();
        sumsEnd.add(0); //possibility of 0 selection from end

        sumsEnd.add(A.get(A.size() - 1)); // for last

        for(int i = A.size() - 2, j = 1; i > A.size() - B -1 ; i--, j++){
            int prefixSum = sumsEnd.get(j) + A.get(i);
            sumsEnd.add(prefixSum);
        }

        return sumsEnd;
    }
}
