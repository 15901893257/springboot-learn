package com.dql.learn.bingfa.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dengquanliang
 * Created on 2021/3/23
 */
public class TestMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(new MyThreadFactory());
        for (int i = 0; i < 10; i++) {
//            executorService.execute(new Task());
            executorService.submit(new Task());
        }
        executorService.shutdown();
    }
}
