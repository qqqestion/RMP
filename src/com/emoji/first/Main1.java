package com.emoji.first;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        // write your code here
        // Заполните массив случайным числами и выведете максимальное, минимальное и
        // среднее значение.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int min = 10, max = -1, totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
            totalSum += arr[i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.printf("Max value: %d\nMin value: %d\nMean value: %f", max, min, totalSum * 1.0 / n);
    }
}
