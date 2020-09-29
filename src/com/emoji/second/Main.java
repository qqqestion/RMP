package com.emoji.second;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector v1 = new Vector(1, 0, 0);
        Vector v2 = new Vector(0, 1, 0);
        System.out.println(v1.angleBetween(v2));
        System.out.println(Arrays.toString(Vector.getRandomArray(10)));
    }
}
