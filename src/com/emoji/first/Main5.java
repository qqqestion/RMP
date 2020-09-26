package com.emoji.first;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main5 {

    public static int fibSeq(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fibSeq(n - 1) + fibSeq(n - 2);
    }

    public static void main(String[] args) {
        // write your code here
        // Вычислить N-е число Фибоначчи.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("fibSeq(" + n + ") = " + fibSeq(n));
    }
}
