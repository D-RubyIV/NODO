package org.example.part2.DaHinh;

public abstract class Animal {
    private String name;
    private int age;

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    abstract String getNames();

    void changeName(){
        this.name = "New Name";
    }

    void run(){
        System.out.println("Animal is running");
    }

}
