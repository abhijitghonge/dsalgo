package com.ag.lld;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        ExecutorService pool = Executors.newCachedThreadPool();

        int x = scanner.nextInt();
        ArrayList<Future<Void>> futures = new ArrayList<>();

        for(int i=1; i<=x; i++){
            Future<Void> future = pool.submit(new TableCreator(i));

            futures.add(future);
        }

        for(Future<Void> future: futures){
            future.get();
        }

        pool.shutdown();
    }
}

class TableCreator implements Callable<Void> {

    private int x;

    public TableCreator(int x){
        this.x = x;
    }

    public Void call(){
        printMultiplicationTable(x);
        return null;
    }

    private void printMultiplicationTable(int x){

        for(int i=1; i<=10; i++){
            System.out.println( x+" times "+i+" is "+x*i);
        }
    }

}