package com.emoji.colletions;

import java.util.HashMap;
import java.util.Map;

public class Main6 {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3, 4, 1, 2, 6, 1};
        System.out.println(arrayToMap(integers));

        String[] strings = new String[]{"Hello", "World", "Hello", "Table"};
        System.out.println(arrayToMap(strings));
    }

    public static <K> Map<K, Integer> arrayToMap(K[] ks) {
        Map<K, Integer> counter = new HashMap<>();
        for (K k : ks) {
            counter.put(k, counter.getOrDefault(k, 0) + 1);
        }
        return counter;
    }
}
