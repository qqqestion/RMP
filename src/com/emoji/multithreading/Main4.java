package com.emoji.multithreading;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) throws Exception {
        Manager manager = new Manager();
        Thread thread1 = new NewThread(manager);
        Thread thread2 = new NewThread(manager);
        thread1.start();
        thread2.start();
    }
}

class Manager {
    private int counter = 0;

    public synchronized void printName() {
        while (counter < 6) {
            this.notify();
            System.out.println(Thread.currentThread().getName());
            counter++;
            if (counter == 6) {
                break;
            }
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

}

class NewThread extends Thread {
    private Manager manager;

    public NewThread(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        manager.printName();
    }
}
