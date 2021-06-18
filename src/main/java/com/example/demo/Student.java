package com.example.demo;

public class Student implements Cloneable {
    String name;
    String city;
    long timestamp;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
