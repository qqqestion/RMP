package com.emoji.projfinal.http;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class DownloadThread extends Thread {
    private Map<String, Set<String>> linksMap;
    private String uploadDirectory;

    public DownloadThread(Map<String, Set<String>> linksMap, String uploadDirectory) {
        this.linksMap = linksMap;
        this.uploadDirectory = uploadDirectory;
    }

    public void downloadFile(URL fileToDownloadURL, File fileToSave) throws IOException {
        BufferedInputStream in = new BufferedInputStream(fileToDownloadURL.openStream());
        if (!fileToSave.exists()) {
            fileToSave.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(fileToSave.getAbsoluteFile());
        byte[] dataBuffer = new byte[1024];
        int bytesRead;
        System.out.println("Downloading: " + fileToSave.getName());
        long totalBytesNumber = 0;
        long start = System.nanoTime();
        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
            totalBytesNumber += bytesRead;
            fileOutputStream.write(dataBuffer, 0, bytesRead);
        }
        double totalTimeInSeconds = (System.nanoTime() - start) * 1.0 / 1000000000;
        System.out.println("Downloaded: " + fileToSave.getName() + " -> " + totalBytesNumber + " bytes in " + String.format("%.3f", totalTimeInSeconds) + " seconds");
    }

    public void copyFile(File origin, File fileToCopy) {
        System.out.println("Downloading: " + fileToCopy.getName());
        long totalBytesNumber = 0;
        long start = System.nanoTime();
        try (InputStream in = new BufferedInputStream(
                new FileInputStream(origin));
             OutputStream out = new BufferedOutputStream(
                     new FileOutputStream(fileToCopy))) {

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                totalBytesNumber += lengthRead;
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }
        double totalTimeInSeconds = (System.nanoTime() - start) * 1.0 / 1000000000;
        System.out.println("Downloaded: " + fileToCopy.getName() + " -> " + totalBytesNumber + " bytes in " + String.format("%.3f", totalTimeInSeconds) + " seconds");
    }

    @Override
    public void run() {
        for (Map.Entry<String, Set<String>> pair : linksMap.entrySet()) {
            URL fileUrl;
            try {
                fileUrl = new URL(pair.getKey());
            } catch (MalformedURLException e) {
                e.printStackTrace();
                continue;
            }
            String[] allFilenames = pair.getValue().toArray(String[]::new);
            File fileToDownload = new File(Paths.get(uploadDirectory, allFilenames[0]).toString());

            try {
                downloadFile(fileUrl, fileToDownload);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
            for (int i = 1; i < allFilenames.length; i++) {
                File copied = new File(uploadDirectory, allFilenames[i]);
                copyFile(fileToDownload, copied);
            }
        }
    }
}
