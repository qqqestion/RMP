package com.emoji.colletions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalTime;
import java.util.*;

public class Main3 {
    private static final int MAX_ELEMENTS = 1000000;
    private static final int PICKING_NUMBER = 100000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        addElements(arrayList, true);
        addElements(linkedList, false);
        pickElement(arrayList, true);  // Это займет 0.03 секунды
        pickElement(linkedList, false);  // Не надо это займет 123 секунды((((
    }

    public static void addElements(List<Integer> list, boolean isArrayList) {
        String containerName = (isArrayList) ? "ArrayList" : "LinkedList";
        long start = System.nanoTime();
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            list.add((int) (Math.random() * 1000));
        }
        long end = System.nanoTime();
        System.out.println("Adding " + MAX_ELEMENTS + " elements to the " + containerName + " takes " + (end - start) * 1.0 / 1000000000);
    }

    public static void pickElement(List<Integer> list, boolean isArrayList) {
        String containerName = (isArrayList) ? "ArrayList" : "LinkedList";
        long start = System.nanoTime();
        for (int i = 0; i < PICKING_NUMBER; i++) {
            int element = list.get((int) (Math.random() * MAX_ELEMENTS));
        }
        long end = System.nanoTime();
        System.out.println("Picking " + PICKING_NUMBER + " times random element of " + containerName + " takes " + (end - start) * 1.0 / 1000000000);
    }
}
