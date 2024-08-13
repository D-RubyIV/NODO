package org.example.part2.Static;

public class StaticBlock {

    private static String subject;

    static {
        System.out.println("Khối static được gọi 1");
    }

    static {
        subject = "Khối static (static blocks)";
        System.out.println("Khối static được gọi 2");
    }

    StaticBlock() {
        System.out.println("hàm main() được gọi");
        System.out.println("Subject = " + subject);
    }

    public static void main(String[] args) {
        StaticBlock ex1 = new StaticBlock();
    }
}