package com.emoji.projfinal.http;

import java.util.*;

public class Downloader {
    private final Map<String, Set<String>> linksMap;
    private final String uploadDirectory;
    private List<Thread> threadList;

    public Downloader(Map<String, Set<String>> links, String uploadDirectory) {
        this.linksMap = links;
        this.uploadDirectory = uploadDirectory;
    }

    public void startDownload(int threadNumber) {
        threadNumber = Math.min(threadNumber, linksMap.size());
        threadList = new ArrayList<>(threadNumber);

        int howManyFilesToThread = linksMap.size() / threadNumber;
        int remains = linksMap.size() % threadNumber;
        if (remains == 0) {
            Map<String, Set<String>> linksForEachThread = new HashMap<>(howManyFilesToThread);
            for (Map.Entry<String, Set<String>> pair : linksMap.entrySet()) {
                if (linksForEachThread.size() < howManyFilesToThread) {
                    linksForEachThread.put(pair.getKey(), pair.getValue());
                }

                if (linksForEachThread.size() == howManyFilesToThread) {
                    Thread childThread = new DownloadThread(linksForEachThread, uploadDirectory);
                    childThread.start();
                    threadList.add(childThread);
                    linksForEachThread = new HashMap<>(howManyFilesToThread);
                }
            }
        } else {

        }
    }

}
