package org.example.part2.KeThua;

public class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println("Animal is running");
    }

    public void jump(){
        System.out.println("Animal is jumping");
    }
}
