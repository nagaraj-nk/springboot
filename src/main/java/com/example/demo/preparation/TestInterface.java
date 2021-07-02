package com.example.demo.preparation;

@FunctionalInterface
public interface TestInterface {

    String hi = "Hi";

    static String testDefault() {
        return "hi";
    }

    void functionalInterface();
}
