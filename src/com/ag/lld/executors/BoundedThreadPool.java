package com.ag.lld.executors;

import java.util.concurrent.*;

public class BoundedThreadPool {
    public static ThreadPoolExecutor newThreadPool(int minThreads, int maxThreads, int queueSize, RejectedExecutionHandler handler) {

        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(queueSize);
        return new ThreadPoolExecutor(minThreads, maxThreads, 0L, TimeUnit.MILLISECONDS,queue, handler );
    }

    public static void main(String[] args) {
        int minThreads = 1;
        int maxThreads = 10;
        int queueSize = 10000;

        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();

        ThreadPoolExecutor pool = newThreadPool(minThreads, maxThreads, queueSize, handler);

    }
}
