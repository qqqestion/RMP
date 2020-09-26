package com.emoji.first;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        // write your code here
        // Найти алгебраическую сумму для выражения: 1^k + 2^k + 3^k + ... + n^k
        // N и степень вводит пользователь.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        long totalSum = 0;
        for (int i = 1; i <= n; i++) {
            totalSum += Math.pow(i, k);
        }
        System.out.println("totalSum = " + totalSum);
    }
}
