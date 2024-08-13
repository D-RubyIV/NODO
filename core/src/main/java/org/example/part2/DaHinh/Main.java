package org.example.part2.DaHinh;


public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog( 20, "Bit pull");
        dog.run();
        System.out.println(dog.getName());
        dog.changeName();
        System.out.println(dog.getName());
    }
}
