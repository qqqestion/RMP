package com.emoji.first;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main6 {

    public static int count(int[] array, int numToCount) {
        int count = 0;
        for (int item : array) {
            if (item == numToCount) {
                count++;
            }
        }
        return count;
    }

    public static int[] deleteNumber(int[] array, int numToDelete) {
        int entryCount = count(array, numToDelete);
        int[] newArray = new int[array.length - entryCount];
        int i = 0, j = 0;
        while (i < array.length && j < newArray.length) {
            if (array[i] != numToDelete) {
                newArray[j] = array[i];
                j++;
            }
            i++;
        }

        return newArray;
    }

    public static void main(String[] args) {
        // write your code here
        // Дан массив чисел и число. Удалите все вхождения числа в массив (пропусков быть не должно).
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        int numToDelete = scanner.nextInt();
        int[] newArray = deleteNumber(array, numToDelete);
        System.out.println(Arrays.toString(newArray));
    }
}
