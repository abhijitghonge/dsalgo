package com.ag.lld.callables;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class AreaCreator implements Callable<ArrayList<Integer>> {
    private int n;
    public AreaCreator(int n){
        this.n = n;
    }
    @Override
    public ArrayList<Integer> call() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        return list;
    }
}
