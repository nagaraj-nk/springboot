package com.example.demo.wissen;

import java.util.*;

import static java.util.Objects.hash;

public class Interview {
    public static void main(String[] args) {
        // treeMap();
        hashMap();
        // list();
        // treeSet();
        // hash();
    }

    static void hash() {
        System.out.println(Objects.hash("7", "raja"));
        System.out.println(Objects.hash("7", "raja"));
    }

    private static void treeSet() {
        TreeSet<Employee> employees = new TreeSet<>();
        Employee employee = new Employee();
        employee.id = 4;
        employees.add(employee);

        Employee employee1 = new Employee();
        employee1.id = 4;
        employees.add(employee1);

        for (Employee employee2 : employees) {
            System.out.println(employee2);
        }
    }

    private static void list() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        Iterator<Integer> iterator = integerList.iterator();

        while (iterator.hasNext()) {
            int num = iterator.next();
            System.out.println(num);
            integerList.remove(new Integer(3));
        }
    }

    private static void hashMap() {
        Map<Employee, Integer> map = new HashMap<>();

        Employee employee1 = new Employee();
        employee1.id = 2;

        Employee employee2 = new Employee();
        employee2.id = 2;

        map.put(employee1, 1);
        map.put(employee2, 2);

        for (Map.Entry<Employee, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey().hashCode() + " " + entry.getValue());
        }
    }

    private static void treeMap() {
        TreeMap<Employee, Integer> treeMap = new TreeMap<>();
        Employee employee = new Employee();
        employee.id = 7;

        Employee employee2 = new Employee();
        employee2.id = 6;

        treeMap.put(employee, 67);
        treeMap.put(employee2, 45);

        SortedSet<Map.Entry<Employee, Integer>> entries = entriesSortedByValues(treeMap);

        for (Map.Entry<Employee, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<>(
                (e1, e2) -> {
                    int res = e1.getValue().compareTo(e2.getValue());
                    return res != 0 ? res : 1;
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}
