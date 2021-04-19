package com.dql.learn.bingfa.thread;

/**
 * @author dengquanliang
 * Created on 2021/3/24
 */
public class Task implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starts");
    }
}
