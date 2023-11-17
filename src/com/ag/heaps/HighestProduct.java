package com.ag.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HighestProduct {

    private class Pair{
        int index;
        int value;
        Pair(int index, int value){
            this.index = index;
            this.value = value;
        }
    }


    public int maxp3(ArrayList<Integer> A) {
        Queue<Pair> max3 = new PriorityQueue<>(Comparator.comparingInt(p-> p.value));
        Queue<Pair> negatives = new PriorityQueue<>((p1,p2)-> p2.value - p1.value);
        int max = Integer.MIN_VALUE;

        for(int i=0; i< A.size(); i++){
            int element = A.get(i);
            if(max3.size()<3){
                max3.offer(new Pair(i, A.get(i)));
            }else if(element > max3.peek().value){
                max3.offer(new Pair(i, element));
                max3.poll();
            }


            if(A.get(i)<0){
                if(max3.size()<2){
                    negatives.offer(new Pair(i, element));
                }else {

                    if(element < negatives.peek().value){
                        negatives.offer(new Pair(i, element));
                        negatives.poll();
                    }
                }
            }

            max = Math.max(element, max);

        }

        // System.out.printf("f:[k:%d, v:%d] s:[k:%d, v:%d] mp:%d %n", first, A.get(first), second, A.get(second), max2product);

        int answer = max;

        while(!negatives.isEmpty()){
            answer *=negatives.poll().value;
        }


        System.out.print("max 3:[");
        int interim = 1;
        while(!max3.isEmpty()){
            interim *= max3.poll().value;
        }
        System.out.println("]");



        return Math.max(answer, interim);

    }
}
