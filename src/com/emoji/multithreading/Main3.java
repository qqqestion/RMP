package com.emoji.multithreading;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        NewCounter counter = new NewCounter();
        for (int i = 0; i < 100; i++) {
            MyNewThread childThread = new MyNewThread(counter);
            childThread.start();
        }
//        Thread.sleep(1000);
        System.out.println(counter.getCount());
    }
}

class NewCounter {
    int count = 0;

    public void increment() {
        count = count + 1;
    }

    public int getCount() {
        return count;
    }
}

class MyNewThread extends Thread {
    private NewCounter counter;

    public MyNewThread(NewCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
