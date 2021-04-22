package com.dql.learn.bingfa.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author dengquanliang
 * Created on 2021/4/20
 */
public class MoreExecutorTest {
    private static final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("async-pool-%d").build();
    private static final ExecutorService executorService = new ThreadPoolExecutor(
            10,
            20,
            0,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(3000),
            threadFactory);
    @Test
    public void testAddDelayShutDownHook() {
        executorService.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "@666");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(Thread.currentThread().getName() + "@888");
//        MoreExecutors.addDelayedShutdownHook(executorService, 3000, TimeUnit.MILLISECONDS);
    }
}
