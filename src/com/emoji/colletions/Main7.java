package com.emoji.colletions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main7 {
    public static void main(String[] args) {
        Map<Integer, Integer> scoreCounter = new HashMap<>(Map.of(
                1, 2,
                2, 1,
                3, 3,
                4, 2
        ));
        System.out.println(mapToMap(scoreCounter));
        Map<String, Integer> wordCounter = new HashMap<>(Map.of(
                "Hello", 3,
                "World", 1,
                "Plane", 3,
                "Name", 2
        ));
        System.out.println(mapToMap(wordCounter));
    }

    public static <K, V> Map<V, List<K>> mapToMap(Map<K, V> map) {
        Map<V, List<K>> counter = new HashMap<>();

        for (Map.Entry<K, V> pair : map.entrySet()) {
            if (!counter.containsKey(pair.getValue())) {
                counter.put(pair.getValue(), new ArrayList<>());
            }
            List<K> list = counter.get(pair.getValue());
            list.add(pair.getKey());
        }

        return counter;
    }
}
