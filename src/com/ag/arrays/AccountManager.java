package com.ag.arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountManager {

    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        Integer[] numbers = {1, 4, 5, 9, 10, 14, 15, 18, 19, 20};
        ArrayList<Integer> orderTimes = Stream.of(numbers).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> available = manager.solve(1, 3, orderTimes);

       // available.forEach(System.out::println);

        Integer[] numbers2 = {0,1,6,11};
        ArrayList<Integer> orderTimes2 = Stream.of(numbers2).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> available2 = manager.solve(4, 5, orderTimes2);

        available2.forEach(System.out::println);
    }

    public ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C) {
        ArrayList<Integer> busy = new ArrayList<>();
        int totalAvailable = A;

        ArrayList<Integer> availableAccounts = new ArrayList<>();

        for(int time: C){
            int available = checkAvailable(busy, time);
            
            totalAvailable = totalAvailable + available;

            if(totalAvailable>=1){
                //allot
                totalAvailable--;
                busy.add(time + B);
            }

            availableAccounts.add(totalAvailable);

        }

        return availableAccounts;

    }

    private int checkAvailable(ArrayList<Integer> busyAccounts, int time){

        if(busyAccounts.size() == 0) return 0;

        int available = 0;

        Iterator<Integer> iter = busyAccounts.iterator();
        while(iter.hasNext()){
            int busyTill = iter.next();

            if(busyTill <= time){
                available++;
                iter.remove();
            }
        }
        return available;

    }
}
