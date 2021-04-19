package com.dql.learn.bingfa.thread;

import lombok.Data;

/**
 * @author dengquanliang
 * Created on 2021/3/24
 */
@Data
public class Letter {
    private String letter = "a";

    public Letter() {
        this.letter = "a";
    }

    public void print() {
        System.out.print(letter);
    }

    public void printA() throws InterruptedException {
        synchronized (this) {
            while (!("a").equals(letter)) {
                wait();
            }
            print();
            setLetter("b");
            notifyAll();
        }
    }

    public void printB() throws InterruptedException {
        synchronized (this) {
            while (!("b").equals(letter)) {
                wait();
            }
            print();
            setLetter("c");
            notifyAll();
        }
    }

    public void printC() throws InterruptedException {
        synchronized (this) {
            while (!("c").equals(letter)) {
                wait();
            }
            print();
            setLetter("a");
            notifyAll();
        }
    }
}
