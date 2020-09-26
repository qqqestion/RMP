package com.emoji.first;

import java.lang.reflect.Array;
import java.util.*;

public class Main8 {

    public static void main(String[] args) {
        // write your code here
        // Дан массив и число K. Найдите первые K самых часто встречающихся элементов.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> numsCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int elem = scanner.nextInt();
            numsCount.put(elem, numsCount.getOrDefault(elem, 0) + 1);
        }
        int k = scanner.nextInt();
        Map<Integer, ArrayList<Integer>> reversedNumsCount = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : numsCount.entrySet()) {
            ArrayList<Integer> allNumsWithCurrentAppearance = reversedNumsCount.getOrDefault(entry.getValue(), new ArrayList<>());
            allNumsWithCurrentAppearance.add(entry.getKey());
            reversedNumsCount.put(entry.getValue(), allNumsWithCurrentAppearance);
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry : reversedNumsCount.entrySet()) {
            for (int elem : entry.getValue()) {
                if (k == 0) {
                    return;
                }
                System.out.println(elem + " repeats " + entry.getKey());
                k--;
            }
        }
    }
}
