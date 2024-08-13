package org.example.part3;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class EqualPerson {
    public static void main(String[] args) {
        Person p1 = new Person("Dion");
        Person p2 = new Person("Dion");
        Person p3 = new Person("Banana");

        Set<Person> set = new LinkedHashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);

        System.out.println(set.size());
        System.out.println(p1.equals(p2));
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
