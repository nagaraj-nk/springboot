package com.example.demo.preparation;

import java.util.HashMap;

public class CollectionThread extends Thread {

    HashMap<Integer, Integer> integerIntegerHashMap;

    public CollectionThread(HashMap<Integer, Integer> integerIntegerHashMap) {
        this.integerIntegerHashMap = integerIntegerHashMap;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 23456; i++) {
            integerIntegerHashMap.put(i, i);
        }
    }

}
