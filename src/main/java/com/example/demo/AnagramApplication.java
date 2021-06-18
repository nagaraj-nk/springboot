package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramApplication {

    public static void main(String[] args) {
        System.out.println("AnagramApplication");

        List<String> anagrams = new ArrayList<>();
        List<String> allWords = new ArrayList<>();

        try {
            File file = new File("C:\\Users\\Nagaraj\\Desktop\\words_alpha.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String readLine = "";
            while ((readLine = bufferedReader.readLine()) != null)
                allWords.add(readLine);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < allWords.size() - 1; i++) {
            for (int j = i + 1; j < allWords.size() - 1; j++) {
                String word1 = allWords.get(i);
                String word2 = allWords.get(j);
                if (word1.length() == word2.length()) {
                    boolean flag = isAnagram(word1, word2);
                    if (flag) {
                        anagrams.add(word1);
                        anagrams.add(word2);
                    }
                }
            }
        }

        for (String anagram : anagrams)
            System.out.print(anagram + " ");
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
