package com.ag.arrays;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrefixProducts {
    public static void main(String[] args) {
        PrefixProducts prefixProducts = new PrefixProducts();

        Integer[] numbers = {1,2,3,4,5};
        ArrayList<Integer> numberList = Stream.of(numbers).collect(Collectors.toCollection(ArrayList::new));
        prefixProducts.solve(numberList).forEach(System.out::println);
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int[] prefixes = prefixProducts(A);
        int[] sufixes = sufixProducts(A);

        ArrayList<Integer> productsExceptMe = new ArrayList<>();
        for(int i=0; i< A.size(); i++){
            productsExceptMe.add(prefixes[i]* sufixes[i]);
        }

        return productsExceptMe;
    }

    private int[] prefixProducts(ArrayList<Integer> A){
        int[] prefixes = new int[A.size()];
        prefixes[0] = 1;

        for(int i=1; i< A.size(); i++){
            prefixes[i] = A.get(i-1) * prefixes[i-1];
        }

        return prefixes;
    }

    private int[] sufixProducts(ArrayList<Integer> A){
        int[] sufixProducts = new int[A.size()];

        sufixProducts[A.size() - 1] = 1;
        for(int i=A.size() -2 ; i >= 0; i--){
            sufixProducts[i] = sufixProducts[i+1] * A.get(i+1);
        }

        return sufixProducts;
    }



}
