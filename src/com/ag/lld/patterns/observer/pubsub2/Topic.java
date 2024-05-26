package com.ag.lld.patterns.observer.pubsub2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class Topic <T>{
    private List<Consumer<T>> consumers;
    private ExecutorService service;


    public Topic(){
        this.consumers = new ArrayList<>();
        service = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(50));
    }

    public void subscribe(Consumer<T> consumer) {
        consumers.add(consumer);
    }

    public void unsubscribe(Consumer<T> consumer) {
        consumers.remove(consumer);
    }


    public void notify(T data){
        consumers.forEach(consumer -> service.execute(()-> consumer.accept(data)));

    }
}
