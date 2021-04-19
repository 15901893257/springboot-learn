package com.dql.learn.bingfa.thread;

/**
 * @author dengquanliang
 * Created on 2021/3/24
 */
public class PrintMain {
    public static void main(String[] args) {
        Letter letter = new Letter();
        Thread threadA = new Thread(new PrintTaskA(letter));
        Thread threadB = new Thread(new PrintTaskB(letter));
        Thread threadC = new Thread(new PrintTaskC(letter));
        threadB.start();
        threadA.start();
        threadC.start();
    }
}

