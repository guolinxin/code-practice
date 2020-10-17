package com.guo.practice.codepractice.problems.thread;

import lombok.SneakyThrows;

public class MyThread1 implements Runnable{
    private Object objectLock1;
    private Object objectLock2;

    public MyThread1(Object objectLock1, Object objectLock2) {
        this.objectLock1 = objectLock1;
        this.objectLock2 = objectLock2;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (objectLock1) {
            System.out.println("Get lock object lock 1");
            Thread.sleep(5000);

            synchronized (objectLock2){
                System.out.println("Get lock object lock 2");
            }
        }
    }
}
