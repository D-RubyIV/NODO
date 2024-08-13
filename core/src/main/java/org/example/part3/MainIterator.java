package org.example.part3;

import java.util.*;

public class MainIterator {
    public static void main(String[] args) {
        Person p1 = new Person("Nam");
        Person p2 = new Person("Quân");
        Person p3 = new Person("Hải");

        List<Person> list = new ArrayList<>(List.of(p1, p2, p3));

        Iterator<Person> personIterator = list.iterator();
        while (personIterator.hasNext()){
            Person p = personIterator.next();
            System.out.println(p.getName());
            if (p.getName().equals("Hải")){
                personIterator.remove();
            }
        }

        System.out.println(list);




    }
}
