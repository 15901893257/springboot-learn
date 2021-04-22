package com.dql.learn.bingfa.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * @author dengquanliang
 * Created on 2021/4/19
 */
public class MainTest1 {
    private static final int SLEEP_TIME = 5000;
    public static void main(String[] args) {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(MyExecutor.EXECUTOR);
        List<Integer> list = new ArrayList<>();
        final List<ListenableFuture<List<Integer>>> futures = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            ListenableFuture<List<Integer>> future = service.submit(() -> getList());
            Futures.addCallback(future, new FutureCallback<List<Integer>>() {
                @Override
                public void onSuccess(@Nullable List<Integer> integers) {
                    System.out.println("成功：" + Thread.currentThread().getName() + " result: " + integers);
                }

                @Override
                public void onFailure(Throwable throwable) {
                    System.out.println("失败：" + Thread.currentThread().getName());
                }
            }, service);
            /**
             * future.get()会等待任务执行完，这样所有线程将会按顺序阻塞执行，失去线程并行的作用
             */
//            list.addAll(future.get());
            futures.add(future);
        }

//        futures.forEach(future -> {
//            try {
//                list.addAll(future.get());
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        });
        futures.forEach(future -> {
            list.addAll(Futures.getUnchecked(future));
//            list.addAll(Futures.getChecked(future, Exception.class));
        });

        System.out.println(list.size());
        System.out.println(list);
        System.out.println("时间消耗: " + (System.currentTimeMillis() - startTime));
    }

    public static List<Integer> getList() throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        //模拟线程时间消耗
        Thread.sleep(SLEEP_TIME);
        return list;
    }
}
