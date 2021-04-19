package com.dql.learn.bingfa.thread;

/**
 * @author dengquanliang
 * Created on 2021/3/24
 */
public class PrintA implements Runnable {
    private Letter letter;

    public PrintA(Letter letter) {
        this.letter = letter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (letter) {
                while (!("a").equals(letter.getLetter())) {
                    try {
                        letter.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                letter.print();
                letter.setLetter("b");
                letter.notifyAll();
            }
        }
    }
}
