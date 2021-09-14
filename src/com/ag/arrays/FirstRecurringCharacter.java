package com.ag.arrays;

import java.util.HashSet;
import java.util.Set;

public class FirstRecurringCharacter {
    //Google Question
//Given an array = [2,5,1,2,3,5,1,2,4]:
//It should return 2

//Given an array = [2,1,1,2,3,5,1,2,4]:
//It should return 1

//Given an array = [2,3,4,5]:
//It should return undefined


//Bonus... What if we had this:
// [2,5,5,2,3,5,1,2,4]
// return 5 because the pairs are before 2,2

    public static void main(String[] args) {
        int[] input1 = {2, 5, 1, 2, 3, 5, 1, 2, 4};
        int[] input2 = {2,1,1,2,3,5,1,2,4};
        int[] input3 = {2, 3, 4, 5};

        System.out.println(firstRecurringCharacter(input1));
        System.out.println(firstRecurringCharacter(input2));

        System.out.println(firstRecurringCharacter(input3));

    }

    private static int firstRecurringCharacter(int[] input1) {
        Set<Integer> lookUp = new HashSet<>();
        for (int number : input1) {
            if (lookUp.contains(number)) {
                return number;
            }

            lookUp.add(number);
        }
        return -1;
    }
}
