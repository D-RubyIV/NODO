package org.example.part5;

public class ThreadSynchronization {

    private static final Object lock = new Object();
    private static int count = 0;
    private static final int THREAD_COUNT = 3;

    public static void main(String[] args) {
        Runnable task = () -> {
            synchronized (lock) {
                try {
                    count++;
                    System.out.println(Thread.currentThread().getName() + " started. Count: " + count);
                    if (count < THREAD_COUNT) {
                        lock.wait();  // Chờ các thread khác hoàn thành
                    } else {
                        lock.notifyAll();  // Thông báo cho tất cả các thread
                    }
                    System.out.println(Thread.currentThread().getName() + " finished.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task, "Thread 3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
