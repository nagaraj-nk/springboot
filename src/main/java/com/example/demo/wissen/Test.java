package com.example.demo.wissen;

import java.util.Collections;
import java.util.HashSet;

public class Test {

    public static void main(String[] args) {

        HashSet<Student> hashSet = new HashSet();
        Student s1 = new Student();
        s1.age = 1;
        s1.name = "rohit";

        hashSet.add(s1);

        Student s2 = new Student();
        s2.age = 4;
        s2.name = "raja";

        hashSet.add(s2);

        Student student = new Student();
        student.name = "chinna";
        student.age = 3;

        hashSet.add(student);

        Student student1 = new Student();
        student1.name = "arun";
        student1.age = 2;

        hashSet.add(student1);

        for (Student student2 : hashSet) {
            System.out.println(student2.name);
        }
    }
}
