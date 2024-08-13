package org.example.part5;




class CustomRunableThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println("A " + i);
        }
    }
}

class CustomThread extends Thread{
    public void run(){
        for (int i = 0; i < 10; i++){
            System.out.println("B " + i);
        }
    }
}


public class MutliThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new CustomRunableThread());
        t1.start();

        Thread t2 = new CustomThread();
        t2.start();

    }
}
