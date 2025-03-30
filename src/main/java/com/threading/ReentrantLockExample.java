package com.threading;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource2 {
    private final ReentrantLock lock = new ReentrantLock();

    void printNumbers(int n) {
        lock.lock(); // Acquire lock
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + (n * i));
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // Release lock
        }
    }
}

public class ReentrantLockExample {
    public static void main(String[] args) {
        SharedResource2 resource = new SharedResource2();

        Thread t1 = new Thread(() -> resource.printNumbers(2));
        Thread t2 = new Thread(() -> resource.printNumbers(3));

        t1.start();
        t2.start();
    }
}
