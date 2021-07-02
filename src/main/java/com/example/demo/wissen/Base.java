package com.example.demo.wissen;

import java.util.function.Function;

public abstract class Base {

    abstract void method();

    public static void main(String[] args) {
        System.out.println("hello");
    }
}

@FunctionalInterface
interface TestIfc {

    int a = 1;

    void test();

    static void test2() {

    }

    static void test23() {

    }

    default void test253() {

    }
}

class TestClass2 implements TestIfc {

    @Override
    public void test() {
        test253();
    }

    @Override
    public void test253() {

    }

    static void test2() {

    }
}