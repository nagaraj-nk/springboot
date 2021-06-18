package com.example.demo;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Application {

    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        // streams();
        // hashCollision();
        // uuid();
        // System.out.println(jwt());
        // lambda();
        // predicate();
        // stackCollections();
        // comparable();
        comparator();
    }

    private static void comparator() {
        Stack<Integer> stack = new Stack<>();
        stack.push(45);
        stack.push(26);
        stack.push(13);
        stack.push(13);
        stack.push(74);
        stack.push(55);

        Collections.sort(stack, new IntegerDescComparator());
        Collections.reverse(stack);

        System.out.println(stack);
    }

    private static void comparable() {
        List<String> strings = new ArrayList<>();
        strings.add("naga");
        strings.add("raja");
        strings.add("abhi");
        strings.add("chaitra");

        Collections.sort(strings);
        System.out.println(strings);
    }

    private static void stackCollections() {
        Stack<Integer> stack = new Stack<>();
        stack.push(45);
        stack.push(26);
        stack.push(13);
        stack.push(74);
        stack.push(55);
        List<Integer> l = stack.stream().sorted().collect(Collectors.toList());
        System.out.println(l);

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);
        copyOnWriteArrayList.add(4);

        Iterator<Integer> iterator = copyOnWriteArrayList.listIterator();

        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2) {
                copyOnWriteArrayList.remove(integer);
            }
        }

        System.out.println(copyOnWriteArrayList);
    }

    private static void predicate() {
        Predicate<Integer> noGreaterThan5 = (x) -> new Integer(x).equals(1);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect = list.stream()
                .filter(noGreaterThan5)
                .collect(Collectors.toList());
        System.out.println(collect); // [6, 7, 8, 9, 10]
    }

    private static void lambda() {
        LambdaTest lambdaTest = new LambdaTest();
        lambdaTest.get("hi", System.out::println);
    }

    private static String jwt() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        String key = "nagaraj";
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        String data = "this is data";
        return Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes("UTF-8")));
    }

    private static void uuid() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
    }

    public static void hashCollision() {
        Student s1 = new Student();
        s1.name = "chidambaram";
        s1.city = "chidambaram";
        s1.timestamp = new Date().getTime();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Student s2 = new Student();
        s2.name = "chidambaram";
        s2.city = "chidambaram";
        s2.timestamp = new Date().getTime();

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }

    public static void streams() {
        List<String> names = Arrays.asList("Naga", "Deva", "Raja", "Kumar", "Karthi");
        List newL = names.stream().filter(
                n -> n.startsWith("K")
        ).collect(Collectors.toList());

        newL.forEach(Java8Application::print);
        String name = names.stream().filter(n -> n.equalsIgnoreCase("naga"))
                .findAny()
                .orElse(null);

        System.out.println(name);
    }

    private static void print(Object s) {
        System.out.println(s);
    }
}
