package com.emoji.wiki;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final String URL = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srlimit=6&srsearch=";

    public static void printHelp() {
        System.out.println("args: ");
        System.out.println("\t--search: Name of wiki page. Example: --search Arizona.");
    }

    public static boolean isArgsValid(String[] args) {
        boolean res = true;

        if (args.length < 2) {
            res = false;
        }
        if (!args[0].equals("--search")) {
            res = false;
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        if (!isArgsValid(args)) {
            printHelp();
            System.exit(1);
        }
        String wikiPageName = args[1];

        URL url = null;
        try {
            url = new URL(URL + '"' + URLEncoder.encode(wikiPageName, StandardCharsets.UTF_8) + '"');
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Reader reader = new InputStreamReader(url.openStream());
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ResultSet.class, new ResultSetDeserializer())
                .registerTypeAdapter(SearchResult.class, new SearchResultDeserializer())
                .create();
        ResultSet result = gson.fromJson(reader, ResultSet.class);
        if (result.isEmpty()) {
            System.out.println("Looks like we couldn't find anything :(");
        }

        for (SearchResult searchResult : result) {
            System.out.println(searchResult);
        }
    }
}
