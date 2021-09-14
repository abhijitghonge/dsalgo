package com.ag.recursion;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ReverseString {

    private static final Map<String, String>  memoized = new HashMap<>();

    public static void main(String[] args) {
        //Implement a function that reverses a string using iteration...and then recursion!
        System.out.println(ReverseString.reverseString("yoyo mastery"));
        ;
        //should return: 'yretsam oyoy'
    }

    private static String reverseString(String str) {

        if(str.length() == 1) return str;
        final int lastIndex = str.length() -1;

        return memoized.computeIfAbsent(str, s -> s.charAt(lastIndex) + reverseString(s.substring(0, lastIndex)));

    }
}
