package com.emoji.multithreading;

public class Main2 {
    public static void main(String[] args) {
        Thread childThread = new MyThread();
        childThread.start();
    }
}

class MyThread extends Thread {
    public MyThread() {
        System.out.println("Я родился!");
    }

    @Override
    public void run() {
        System.out.println("Я запустился!");

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Я завершился!");
        super.run();
    }
}