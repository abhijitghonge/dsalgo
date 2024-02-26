package com.ag.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MergeSortAlgorithm {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MergeSortAlgorithm algorithm = new MergeSortAlgorithm();
        Integer[] array = {5, 3, 4, 1, 34, 23, 56};

        List<Integer> input = new ArrayList<>(Arrays.asList(array));

        List<Integer> sorted = algorithm.sort(input);

        sorted.forEach(System.out::println);

    }

    private final ExecutorService service;
    public MergeSortAlgorithm(){
        this.service = Executors.newCachedThreadPool();
    }

    public List<Integer> sort(List<Integer> original) throws ExecutionException, InterruptedException {
        if (original.isEmpty() || original.size() == 1) {
            return original;
        }

        int N = original.size();
        int M = N / 2;

        List<Integer> left = new ArrayList<>(original.subList(0, M));
        List<Integer> right = new ArrayList<>(original.subList(M, N));

        SortTask leftTask = new SortTask(left);
        Future<List<Integer>> leftFuture = service.submit(leftTask);

        SortTask rightTask = new SortTask(right);
        Future<List<Integer>> rightFuture = service.submit(rightTask);
        return merge(leftFuture.get(), rightFuture.get());
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add((right.get(j)));
                j++;
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }
        return merged;
    }

    private class SortTask implements Callable<List<Integer>> {

        private List<Integer> original;

        public SortTask(List<Integer> original) {

            this.original = original;
        }

        @Override
        public List<Integer> call() throws ExecutionException, InterruptedException {
            return sort(original);
        }
    }


}
