package org.example.part2.Equals;


class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


public class Main {
    public static void main(String[] args) {
        String name1 = "A";
        String name2 = "A";
        System.out.println("name1 equal name2: "+ name1.equals(name2) );
        System.out.println("name1 == name2: "+ name1 == name2);

        String n1 = new String("A");
        String n2 = new String("A");
        System.out.println("n1 equal n2: "+ n1.equals(n2) );
        System.out.println("n1 == n2: "+ n1 == n2);

        Integer s1 = 5;
        Integer s2 = 5;
        System.out.printf("S1 == S2: {%S}", s1 == s2);
    }
}
