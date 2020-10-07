package com.emoji.colletions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        String filename = "for_dict.txt";
        Scanner scanner;
        try {
            File input = new File(filename);
            scanner = new Scanner(input);
        } catch (FileNotFoundException exp) {
            System.out.println("File doesn't exist");
            return;
        }
        Map<String, Integer> wordCounter = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> pair : wordCounter.entrySet()) {
            System.out.println(pair.getKey() + ' ' + pair.getValue());
        }
    }
}
