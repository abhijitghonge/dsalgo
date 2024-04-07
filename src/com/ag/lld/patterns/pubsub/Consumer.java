package com.ag.lld.patterns.pubsub;

import java.util.concurrent.ArrayBlockingQueue;

public class Consumer<T> {
    private final ArrayBlockingQueue<T> queue;

    public Consumer(ArrayBlockingQueue<T> queue){
        this.queue = queue;
    }
    public T take() throws InterruptedException {
        return queue.take();
    }
}
