package com.ag.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<String>> sentences = Arrays.asList(
                Arrays.asList("This", "is", "a", "sentence"),
                Arrays.asList("Another", "sentence", "with", "fewer", "words")
        );

        int words = sentences.stream()
                .flatMap(Collection::stream)
                .reduce(0, (count, s)-> count+1, Integer::sum);
        System.out.println(words);

    }
}
