package com.ag.arrays;

import java.util.HashSet;
import java.util.Set;

public class CommonItemsCheck {
    public static void main(String[] args) {
        char[] array1 = {'a', 'b', 'c', 'x','x'};
        char[] array2 = {'z', 'y', 'h', 'i'};
        CommonItemsCheck check = new CommonItemsCheck();
        System.out.println(check.containsCommonItem(array1, array2));
    }
        
    public boolean containsCommonItem(char[] array1, char[] array2){
        Set<Character> itemsLookUp = convertToSet(array1);
        for (char searchItem: array2) {
            if(itemsLookUp.contains(searchItem)) return true;
        }
         return false;
    }

    private Set<Character> convertToSet(char[] array1) {
        Set<Character> lookUp = new HashSet<>();
        for (char item : array1) {
            lookUp.add(item);
        }

        return lookUp;
    }
}
