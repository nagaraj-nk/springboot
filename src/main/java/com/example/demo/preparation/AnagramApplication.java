package com.example.demo.preparation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AnagramApplication {

    List<String> anagrams = new ArrayList<>();
    long startTime;
    long endTime;

    public static void main(String[] args) {
        Runtime.runFinalizersOnExit(true);
        AnagramApplication anagramApplication = new AnagramApplication();
        anagramApplication.processUsingStreams();

    }

    private void processUsingStreams() {
        System.out.println("AnagramApplication");
        List<String> allWords = readData();

        startTime = System.currentTimeMillis();
        Stream<String> stream = allWords.stream();
    }

    private void process() {
        System.out.println("AnagramApplication");
        List<String> allWords = readData();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < allWords.size() - 1; i++) {
            for (int j = i + 1; j < allWords.size() - 1; j++) {
                int finalI = i;
                int finalJ = j;
                /*Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {*/
                String word1 = allWords.get(finalI);
                String word2 = allWords.get(finalJ);
                if (word1.length() == word2.length() && !word1.equalsIgnoreCase(word2)) {
                    boolean flag = isAnagram(word1, word2);
                    if (flag) {
                        anagrams.add(word1);
                        anagrams.add(word2);
                    }
                }
                    /*}
                });
                thread.start();*/
            }
        }
    }

    List<String> readData() {
        List<String> allWords = new ArrayList<>();

        try {
            File file = new File("words_alpha.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String readLine = "";
            while ((readLine = bufferedReader.readLine()) != null)
                allWords.add(readLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allWords;
    }

    @Override
    protected void finalize() throws Throwable {
        endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 1000 + " seconds");
        System.out.println("end");
    }

    public static boolean isAnagram(String word1, String word2) {
        boolean flag = false;

        if (!word1.equalsIgnoreCase(word2)) {
            char[] w1 = word1.toLowerCase().toCharArray();
            char[] w2 = word2.toLowerCase().toCharArray();

            Arrays.sort(w1);
            Arrays.sort(w2);

            flag = Arrays.equals(w1, w2);
        }
        return flag;
    }
}
