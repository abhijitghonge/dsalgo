package com.ag.lld.patterns.observer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Subscriber<T> {

    private final ExecutorService cachedService;


    public Subscriber() {

        cachedService = Executors.newCachedThreadPool();
    }


    public void notify(T data){
        cachedService.submit(getTask(data));
    }


    public abstract Runnable getTask(T data);


}

