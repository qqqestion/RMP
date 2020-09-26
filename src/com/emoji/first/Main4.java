package com.emoji.first;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    private final static int MIN = 1, MAX = 100;

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // write your code here
        // Напишите программу, которая вычислит простые числа в пределах от 2 до 100.
        // Для решения этой задачи понадобится вычислить остаток от деления. В Java для
        // этого есть оператор % (например, 103 % 10 это 3).
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = MIN; i < MAX; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        System.out.println(primeNumbers.toString());
    }
}
