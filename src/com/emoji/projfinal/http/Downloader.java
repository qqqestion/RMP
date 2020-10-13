package com.emoji.projfinal.http;

import java.util.*;

public class Downloader {
    private final Map<String, Set<String>> linksMap;
    private final String uploadDirectory;
    private long bytesCount;
    private long downloadStart;
    private long downloadEnd;
    private int downloadedFileCount;
    private List<Thread> threadList;

    public Downloader(Map<String, Set<String>> links, String uploadDirectory) {
        this.linksMap = links;
        this.bytesCount = 0;
        this.downloadedFileCount = 0;
        this.uploadDirectory = uploadDirectory;
    }

    public void startDownload(int threadNumber) {
        threadNumber = Math.min(threadNumber, linksMap.size());
        threadList = new ArrayList<>(threadNumber);
        downloadStart = System.nanoTime();

        int howManyFilesToThread = linksMap.size() / threadNumber;
        int remains = linksMap.size() % threadNumber;

        // Если количество ссылок на делится нацело на количество потоков, то каким-то потокам
        // достанется на +1 ссылку больше для обработки
        if (remains != 0) {
            howManyFilesToThread++;
        } else {
            remains = -1;  // Если делится нацело, то все окей
        }

        // Занимаем на +1 больше место на всякий случай для дополнительных ссылок
        Map<String, Set<String>> linksForEachThread = new HashMap<>(howManyFilesToThread + 1);
        for (Map.Entry<String, Set<String>> pair : linksMap.entrySet()) {
            if (linksForEachThread.size() < howManyFilesToThread) {
                linksForEachThread.put(pair.getKey(), pair.getValue());
            }

            if (linksForEachThread.size() == howManyFilesToThread) {
                Thread childThread = new DownloadThread(linksForEachThread, uploadDirectory, this);
                childThread.start();
                threadList.add(childThread);
                linksForEachThread = new HashMap<>(howManyFilesToThread + 1);

                remains--;
                // Дополнительные ссылки закончились
                if (remains == 0) {
                    howManyFilesToThread--;
                }
            }
        }

        // Подождем-с пока все потоки отработают
        for (int i = 0; i < threadList.size(); i++) {
            try {
                threadList.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        downloadEnd = System.nanoTime();

        printDownloadInfo();
    }

    private void printDownloadInfo() {
        System.out.println("Downloaded: " + downloadedFileCount + " files, " + convertBytes(bytesCount));
        double totalTime =  (downloadEnd - downloadStart) * 1.0 / 1000000000;
        System.out.println("Total time: " + String.format("%.3f", totalTime) + " seconds");
        System.out.println("Average download speed: " + convertBytes(bytesCount * 1.0 / totalTime) + "/S");
    }

    public long getBytesCount() {
        return bytesCount;
    }

    public void setBytesCount(long bytesCount) {
        this.bytesCount = bytesCount;
    }

    public void incrementFileCount() {
        downloadedFileCount++;
    }

    public static String convertBytes(double bytesCount) {
        String result;
        if (bytesCount < 1024) {
            result = bytesCount + "B";
        } else if (bytesCount < 1_048_576) {
            result = String.format("%.2f", bytesCount * 1.0 / 1024) + "KB";
        } else if (bytesCount < 1_073_741_824) {
            result = String.format("%.2f", bytesCount * 1.0 / 1_048_576) + "MB";
        } else {
            result = String.format("%.2f", bytesCount * 1.0 / 1_073_741_824) + "GB";
        }
        return result;
    }
}
