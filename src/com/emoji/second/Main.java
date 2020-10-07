package com.emoji.second;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector v1 = new Vector(1, 0, 0);
        Vector v2 = new Vector(0, 1, 0);
        System.out.println("Angle: " + v1.angleBetween(v2));
        System.out.println("Add: " + v1.add(v2));
        System.out.println("Dot: " + v1.dotProduct(v2));
        System.out.println("Cross product: " + v1.crossProduct(v2));
        System.out.println("Random vectors: " + Arrays.toString(Vector.getRandomArray(10)));
    }
}
