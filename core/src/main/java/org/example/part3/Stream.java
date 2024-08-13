package org.example.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Stream {
    public static void main(String[] args, Integer e) {
        Person p1 = new Person("Nam");
        Person p2 = new Person("Quân");
        Person p3 = new Person("Hải");

        List<Person> list = new ArrayList<>(List.of(p1, p2, p3));
        List<Integer> numbers = Arrays.asList(7, 2, 5, 4, 2, 1);


        // LỌC
        list.stream().filter(s -> s.getName().equals("Nam")).forEach(System.out::println);
        numbers.stream().filter(s -> s % 2 == 0).forEach(System.out::println);
        //

        //Tạo Stream cho những kiểu primitive
        IntStream.range(1, 4).forEach(System.out::println); // 1 2 3
        DoubleStream.of(1, 2, 3).forEach(System.out::println); // 1.0 2.0 3.0
        System.out.println("DONE P2");


        // Reduce Method
        List<String> strings = Arrays.asList("args", "", "code", "learn", "...");
        String result = strings.stream().reduce("-", String::concat);
        System.out.println(result);
        System.out.println("DONE P3");
        // Min max
        System.out.println("Min Max");
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer maxx = list2.stream().max(Integer::compare).get();
        Integer minn = list2.stream().min(Integer::compare).get();
        System.out.println("Max: " + maxx + "\nMin: " + minn);
        System.out.println("DONE P4");
        // lOẠI TRÙNG LẶP
        System.out.println("lOẠI TRÙNG LẶP");
        List<Integer> list3 = Arrays.asList(1, 2, 2, 2, 2, 3, 4, 5);
        list3.stream().distinct().forEach(s -> System.out.print(s + " "));
        System.out.println("DONE P5");
        // Map Thay đổi
        System.out.println("Map Thay đổi");
        List<Integer> list5 = Arrays.asList(1, 2, 3, 4, 5);
        list5.stream().map(i -> i * i + "OK").forEach(s -> System.out.print(s + " "));
        list5.parallelStream().map(i -> i * i + "OK").forEach(s -> System.out.print(s + " "));
        System.out.println("DONE P6");


        // Map Lọc
        System.out.println("Map Loc Dk > 2");
        List<Integer> list8 = Arrays.asList(1, 2, 2, 2, 2, 3, 4, 5);
        list8.stream().distinct().filter(s -> s>2).forEach(s -> System.out.print(s + " "));
        System.out.println("DONE P7");

        // Stream sắp xếp
        System.out.println("Map Sap Xep");
        List<Integer> list9 = Arrays.asList(4,3,2,1,0,3,4,5);
        list9.stream().sorted((s1, s2) -> s2 - s1).forEach(s -> System.out.print(s + " "));
        System.out.println("DONE P7");
    }
}
