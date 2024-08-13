package org.example.part5;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
        try {
            // Thread sẽ ngủ trong 2 giây, chuyển trạng thái sang sleeping
            System.out.println(Thread.currentThread().getName() + " is sleeping");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " is done sleeping");

            synchronized(this) {
                // Đưa thread vào trạng thái waiting
                System.out.println(Thread.currentThread().getName() + " is waiting");
                wait(2000);
                System.out.println(Thread.currentThread().getName() + " is done waiting");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is exiting");
    }
}

public class VongDoiThread  {
    public static void main(String[] args) {
        // Thread ở trạng thái new
        MyThread thread = new MyThread();

        // Thread chuyển sang trạng thái runnable khi gọi start()
        thread.start();

        try {
            // Main thread sẽ chờ (blocked) cho đến khi MyThread hoàn thành
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Thread đã hoàn thành (dead)
        System.out.println("Main thread exiting");
    }
}
