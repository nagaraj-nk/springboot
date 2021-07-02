package com.example.demo.wissen;

import java.util.Arrays;

public class Varags {

    static void test(int... a) {
        Arrays.stream(a).forEach(System.out::println);
    }

    public static void main(String[] args) {
        //test(1, 2, 3, 4);

        int[] a = {3, 5, 1, 87, 35};

        Arrays.stream(a).parallel().forEach(System.out::println);
    }
}
