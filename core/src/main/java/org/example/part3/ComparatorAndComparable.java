package org.example.part3;

import java.util.*;

public class ComparatorAndComparable {
    public static void main(String[] args) {

        Person p1 = new Person("Nam");
        Person p2 = new Person("Quân");
        Person p3 = new Person("Anh");

        List<Person> list = new LinkedList<>(List.of(p1, p2, p3));

        // Comparator
        Collections.sort(list);

        list.forEach(s -> {
            System.out.println(s.getName());
        });




    }
}
