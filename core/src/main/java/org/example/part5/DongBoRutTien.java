package org.example.part5;

class RutTien {
    private int balance;

    public RutTien(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(int amount) {
        if (this.balance >= amount && this.balance - amount >= 0) {
            balance -= amount;
        } else {
            System.out.println("Số dư không đủ");
        }
    }

    public int getBalance() {
        return balance;
    }
}

class Thread1 extends Thread {
    private final RutTien rutTien;
    private final int index;

    public Thread1(RutTien rutTien, int index) {
        this.rutTien = rutTien;
        this.index = index;
    }

    @Override
    public  void run() {
        while (rutTien.getBalance() > 0){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            rutTien.withdraw(10);
            System.out.printf("Thread %d - Số dư còn lại: %d\n", index, rutTien.getBalance());
        }
    }
}

public class DongBoRutTien {
    public static void main(String[] args) {
        RutTien rutTien = new RutTien(100);

        Thread1 thread1 = new Thread1(rutTien, 1);
        Thread1 thread2 = new Thread1(rutTien, 2);

        thread1.start();
        thread2.start();
    }
}
