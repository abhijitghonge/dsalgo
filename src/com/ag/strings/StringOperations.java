package com.ag.strings;

import java.util.stream.Collectors;

public class StringOperations {

    public static void main(String[] args) {
        String A = "ScalerAcademy";

        for(char ch: A.toCharArray()){
            System.out.println(ch);
        }
        StringOperations operations = new StringOperations();
        String concated = operations.concat(A);
        System.out.println("concatenated:" + concated);

        String replaced = concated.chars().mapToObj(ascii -> (char) ascii)
                .filter(ch -> (ch < 'A' || ch > 'Z'))
                .map(operations::replaceVowels)
                .map(String::valueOf)
                .collect(Collectors.joining());


        System.out.println("replaced:" + replaced);

    }

    private String concat(String A) {
        return A + A;
    }


    private char replaceVowels(char ch) {

        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return '#';
            default:
                return ch;
        }
    }
}

