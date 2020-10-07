package com.emoji.colletions;

import java.util.*;

public class Main2<E> {

    public static void main(String[] args) {
        List<Integer> intElements = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> uniqueIntElements = new Main2<Integer>().deleteRepeated(intElements);
        System.out.println(Arrays.toString(uniqueIntElements.toArray()));

        List<String> stringElements = new ArrayList<>(List.of("Hello", "Work", "Table", "Chair", "Table", "Hello", "WORK"));
        Set<String> uniqueStringElements = new Main2<String>().deleteRepeated(stringElements);
        System.out.println(Arrays.toString(uniqueStringElements.toArray()));
    }

    public Set<E> deleteRepeated(List<E> items) {
        Set<E> unique = new HashSet<>();
        for (E item : items) {
            unique.add(item);
        }
        return unique;
    }
}
