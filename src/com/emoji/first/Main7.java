package com.emoji.first;

import java.lang.reflect.Array;
import java.util.*;

public class Main7 {

    public static void main(String[] args) {
        // write your code here
        // Дан массив чисел. Найдите первое уникальное в это массиве число.
        // Например, для массива [1, 2, 3, 1, 2, 4] это число 3.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        Map<Integer, Integer> uniqueNums = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            uniqueNums.put(array[i], uniqueNums.getOrDefault(array[i], 0) + 1);
        }
        for (int i = 0; i < array.length; i++) {
            if (uniqueNums.get(array[i]) == 1) {
                System.out.println("First unique = " + array[i]);
                return;
            }
        }

    }
}
