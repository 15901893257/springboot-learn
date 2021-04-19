package com.dql.learn.bingfa.future;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dengquanliang
 * Created on 2021/4/13
 */
public class MyExecutor {
    private static final int CORE_POOL_SIZE = 20; //核心线程数
    private static final int MAX_POOL_SIZE = 20; //最大线程池
    private static final int KEEP_ALIVE_TIME = 300; //线程空闲时间
    private static final int QUEUE_LENGTH = 300; //缓存队列长度

    public static final ThreadPoolExecutor EXECUTOR =
            new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
                    TimeUnit.SECONDS, new ArrayBlockingQueue<>(QUEUE_LENGTH), new ThreadFactory() {
                private AtomicInteger i = new AtomicInteger(0);

                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, "testThread-" + i.incrementAndGet());
                }
            });
}
