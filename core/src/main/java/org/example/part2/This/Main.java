package org.example.part2.This;

class Example{
    Example2 obj;
    Example(Example2 obj) {
        this.obj=obj;
    }
    void display() {
        System.out.println(obj.number);// sử dụng biến thành viên cửa lớp A4
    }
}
class Example2 {
    String number = "Example";
    Example2() {
        Example b = new Example(this);
        b.display();
    }
}
public class Main {
    public static void main(String args[]) {
        Example2 e = new Example2();
    }
}