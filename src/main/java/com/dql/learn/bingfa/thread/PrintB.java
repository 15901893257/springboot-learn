package com.dql.learn.bingfa.thread;

/**
 * @author dengquanliang
 * Created on 2021/3/24
 */
public class PrintB implements Runnable {
    private Letter letter;

    public PrintB(Letter letter) {
        this.letter = letter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (letter) {
                while (!("b").equals(letter.getLetter())) {
                    try {
                        letter.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                letter.print();
                letter.setLetter("c");
                letter.notifyAll();
            }
        }
    }
}
