package org.example.part2.KeThua;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    @Override
    public void jump(){
        System.out.println("Dog" + super.getName() + "is jumping");
    }
}

