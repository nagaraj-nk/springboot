package com.example.demo.preparation;

import java.util.Comparator;

public class StringDescComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
