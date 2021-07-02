package com.example.demo.wissen;

import java.util.Objects;

public class Employee implements Comparable<Employee> {

    int id;

    @Override
    public int compareTo(Employee o) {
        return (new Integer(id).compareTo(o.id));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
