package com.ag.sorting;

import java.util.LinkedList;
import java.util.List;

public class InsertionSet {
    public static void main(String[] args) {
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        sort(numbers).forEach(System.out::println);
    }

    public static List<Integer> sort(int[] numbers){//O(n^2)
        List<Integer> list = new LinkedList<>();

        for (int number : numbers) {
            list.add(number);
        }
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if(list.get(i) < list.get(j)){
                    int temp = list.remove(i);
                    list.add(j, temp);
                }
            }

        }

        return list;
    }
}
