package com.ag.lld.patterns.pubsub;

import java.util.concurrent.ArrayBlockingQueue;

public class Producer<T> {

    private final ArrayBlockingQueue<T> queue;

    public Producer(ArrayBlockingQueue<T> queue){
        this.queue = queue;
    }

    public boolean offer(T data){
        return queue.offer(data);
    }
}
