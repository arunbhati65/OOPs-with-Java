package com.threading;

class Resource {
    synchronized void methodA(Resource resource) {
        System.out.println(Thread.currentThread().getName() + " locked methodA");
        try { Thread.sleep(500); } catch (InterruptedException e) {}

        System.out.println(Thread.currentThread().getName() + " waiting for methodB");
        resource.methodB();
    }

    synchronized void methodB() {
        System.out.println(Thread.currentThread().getName() + " locked methodB");
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        Resource res1 = new Resource();
        Resource res2 = new Resource();

        Thread t1 = new Thread(() -> res1.methodA(res2));
        Thread t2 = new Thread(() -> res2.methodA(res1));

        t1.start();
        t2.start();
    }
}

