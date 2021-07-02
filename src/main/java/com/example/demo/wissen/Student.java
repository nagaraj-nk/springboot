package com.example.demo.wissen;

import java.util.Objects;

public class Student implements Comparable<Student> {

    String name;
    int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Student student) {
        return this.name.compareTo(student.name);
    }
}
