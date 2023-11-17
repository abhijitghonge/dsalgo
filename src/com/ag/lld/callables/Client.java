package com.ag.lld.callables;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        ExecutorService service = Executors.newCachedThreadPool();
        AreaCreator creator = new AreaCreator(scanner.nextInt());
        Future<ArrayList<Integer>> listFuture = service.submit(creator);
        System.out.println(listFuture.get());
        service.shutdown();

    }
}
