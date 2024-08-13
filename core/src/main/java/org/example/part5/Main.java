package org.example.part5;

class Store {
    private int contents;
    private boolean available = false;

    public synchronized void put(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        contents = value;
        available = true;
        notifyAll();
    }

    public synchronized int get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        available = false;
        notifyAll();
        return contents;
    }
}

class Producer implements Runnable {
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            store.put(i);
        }
    }
}

class Consumer implements Runnable {
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            store.get();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}