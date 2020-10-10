package com.emoji.multithreading;

public class Main1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Counter counter = new Counter(String.valueOf(i));
            Thread childThread = new Thread(counter);
            childThread.start();
        }
    }
}

class Counter implements Runnable {
    private static final int CEILING = 100;
    private String name;

    public Counter(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < CEILING; i++) {
            System.out.println(name + ": " + i);
        }
    }
}
