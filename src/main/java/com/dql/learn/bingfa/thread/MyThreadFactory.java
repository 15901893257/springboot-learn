package com.dql.learn.bingfa.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dengquanliang
 * Created on 2021/3/23
 */
public class MyThreadFactory implements ThreadFactory {
    private AtomicInteger i = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "MyThread_" + i.incrementAndGet());
    }
}
