package com.dql.learn.bingfa.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import org.apache.commons.collections4.CollectionUtils;
import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dengquanliang
 * Created on 2021/4/13
 */
@Slf4j
public class MainTest {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        init();
        ListeningExecutorService service = MoreExecutors.listeningDecorator(MyExecutor.EXECUTOR);
        ListenableFuture future = service.submit(() -> getStudents());
        List<Student> list = new CopyOnWriteArrayList<>();
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        long startTime = System.currentTimeMillis();

        for (int i= 0; i < 5; i++) {
            Futures.addCallback(future, new FutureCallback<List<Student>>() {
                @Override
                public void onSuccess(@Nullable List<Student> students) {
                    if (CollectionUtils.isNotEmpty(students)) {
                        log.info("添加");
                        list.addAll(students);
                    }
                    log.info(Thread.currentThread().getName());
                    countDownLatch.countDown();
                }

                @Override
                public void onFailure(Throwable throwable) {
                    System.out.println("出错");
                }
            }, service);
        }

        countDownLatch.await();
        System.out.println("耗时: " + (System.currentTimeMillis() - startTime));
        System.out.println(list);
//        System.out.println("完成：" + future.get());
    }

    static void init() {
        for (int i = 0; i < 10; i++) {
            Student student = new Student("mai" + i, i);
            students.add(student);
        }
    }

    static String getName() {
        return null;
    }

    static List<String> getStrings() {
        return null;
    }

    static List<Student> getStudents() throws InterruptedException {
        Thread.sleep(5000);
        return students;
    }
}

@Data
@AllArgsConstructor
class Student {
    private String name;
    private int age;
}
