package com.dql.learn.bingfa.thread;

import lombok.SneakyThrows;

/**
 * @author dengquanliang
 * Created on 2021/3/24
 */
public class PrintTaskB implements Runnable {
    private Letter letter;

    public PrintTaskB(Letter letter) {
        this.letter = letter;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            letter.printB();
        }
    }
}
