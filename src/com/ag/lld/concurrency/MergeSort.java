package com.ag.lld.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class MergeSort implements Callable<List<Integer>> {
    private final List<Integer> unsorted;
    private final ExecutorService service;
    public MergeSort(List<Integer> unsorted, ExecutorService service){
        this.unsorted = unsorted;
        this.service = service;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        ExecutorService service = Executors.newCachedThreadPool();
        MergeSort mergeSort = new MergeSort(Arrays.stream(numbers).collect(Collectors.toList()), service);
        System.out.println(mergeSort.sort());
        service.shutdown();
    }

    public List<Integer> sort() throws ExecutionException, InterruptedException {
        if(unsorted.size()<=1) return unsorted;

        int half = unsorted.size()/2;
        List<Integer> left = new ArrayList<>();
        for(int i=0; i< half; i++){
            left.add(unsorted.get(i));
        }
        List<Integer> right = new ArrayList<>();
        for (int i = half; i < unsorted.size() ; i++) {
            right.add(unsorted.get(i));
        }

        Future<List<Integer>> leftFuture = service.submit(new MergeSort(left, service));
        Future<List<Integer>> rightFuture = service.submit(new MergeSort(right, service));
        List<Integer> leftSorted = leftFuture.get();
        List<Integer> rightSorted = rightFuture.get();

        return merge(leftSorted, rightSorted);
    }

    @Override
    public List<Integer> call() throws Exception {
        return sort();
    }


    private List<Integer> merge(List<Integer> leftSorted, List<Integer> rightSorted){
        List<Integer> merged = new ArrayList<>();
        int i=0, j=0;
        while (i<leftSorted.size() && j < rightSorted.size()){
            if(leftSorted.get(i)<=rightSorted.get(j)){
                merged.add(leftSorted.get(i));
                i++;
            }else{
                merged.add(rightSorted.get(j));
                j++;
            }
        }

        while(i< leftSorted.size()) {
            merged.add(leftSorted.get(i));
            i++;
        }
        while(j< rightSorted.size()) {
            merged.add(rightSorted.get(j));
            j++;
        }

        return merged;
    }
}
