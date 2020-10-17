package com.guo.practice.codepractice.problems.thread;

import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    public void objectLockThreadTest() {
        Object object1 = new Object();
        Object object2 = new Object();

        MyThread1 myThread1 = new MyThread1(object1,object2);
        MyThread2 myThread2 = new MyThread2(object1,object2);

        Thread thread1 = new Thread(myThread1, "T1");
        Thread thread2 = new Thread(myThread2, "T2");

        thread1.start();
        thread2.start();

    }

}
