package com.example.demo.preparation;

import java.util.*;

public class ThreadingCollections {

    Vector<Integer> integers = new Vector<>();

    public static void main(String[] args) {

        ThreadingCollections threadingCollections = new ThreadingCollections();
        threadingCollections.start();
    }

    private void start() {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    integers.add(i);
                }

                for (int i = 0; i < 10; i++) {
                    System.out.println(integers.get(i));
                }
            }
        });
        thread1.start();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < integers.size(); i++) {
                    integers.remove(i);
                }
            }
        });

        thread.start();

    }
}
