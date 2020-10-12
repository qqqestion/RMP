package com.emoji.projfinal.http;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static Map<String, String> setAndParseArgs(String[] args) throws Exception {
        CommandLineParser parser = new CommandLineParser();
        parser.addArgument("-n", "5");
        parser.addArgument("--out", "downloads");
        parser.addArgument("--src");

        return parser.parseArgs(args);
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> parsedArgs = setAndParseArgs(args);

        Scanner scanner;
        try {
            File linksSrc = new File(parsedArgs.get("--src"));
            scanner = new Scanner(linksSrc);
        } catch (FileNotFoundException exp) {
            throw new Exception("Cannot find such file");
        }

        Map<String, Set<String>> linksList = new HashMap<>();
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            if (line.length < 2) {
                throw new Exception("In " + parsedArgs.get("--src") + " incorrect links format, must be: <HTTP link><space><filename>");
            }
            String filepath = line[0].strip(), filename = line[1].strip();
            if (!linksList.containsKey(filepath)) {
                linksList.put(filepath, new HashSet<>());
            }
            Set<String> namesList = linksList.get(filepath);
            namesList.add(filename);
        }
        Downloader fileDownloader = new Downloader(linksList, parsedArgs.get("--out"));
        fileDownloader.startDownload(Integer.parseInt(parsedArgs.get("-n")));
        System.out.println(linksList);
    }
}