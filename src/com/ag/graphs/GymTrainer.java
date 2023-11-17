package com.ag.graphs;

import java.util.HashSet;
import java.util.Set;

public class GymTrainer {
    public static void main(String[] args) {
        GymTrainer trainer = new GymTrainer();
        System.out.println(trainer.powMod(2,3,10000007));

    }

    public int solve(int A, int[][] B, int[][] C) {
        int M = 1000000007;
        int[] parent = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            parent[i] = i;
        }

        Set<Integer> talkers = new HashSet<>();
        //talkers
        for (int i = 0; i < B.length; i++) {
            int friend1 = B[i][0];
            int friend2 = B[i][1];
            union(friend1, friend2, parent);
            talkers.add(root(friend1, parent));
        }

        Set<Integer> walkers = new HashSet<>();
        //walkers
        for (int i = 0; i < C.length; i++) {
            int friend1 = C[i][0];
            int friend2 = C[i][1];
            if (talkers.contains(root(friend1, parent)) || talkers.contains(root(friend2, parent))) {
                return 0;
            }
            union(friend1, friend2, parent);
            walkers.add(root(friend1, parent));
        }
        int total = talkers.size() + walkers.size();
        return powMod(2, total, M);

    }

    private int root(int x, int[] parent){
        if(parent[x]==x){
            return x;
        }else{
            parent[x]=root(parent[x], parent);
            return parent[x];
        }
    }

    private void union(int friend1, int friend2, int[] parent){
        int i = root(friend1, parent);
        int j = root(friend2, parent);

        if(i<j){
            parent[j]=parent[i];
        }else if(i>j){
            parent[i]=parent[j];
        }
    }

    private int powMod(int x, int y, int M) {
        if (y == 0) return 1;

        int half = y / 2;

        long power = powMod(x, half, M);

        if (isOdd(y)) {
            return (int) (((power * power) % M) * x) % M;
        } else {
            return (int) (power * power) % M;
        }
    }

    private boolean isOdd(int x){
        return (x&1)==1;
    }

}
