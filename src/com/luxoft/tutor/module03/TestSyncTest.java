package com.luxoft.tutor.module03;

public class TestSyncTest {
    public static void main(String[] args) {


        TestSync job = new TestSync();
        Thread a = new Thread(job, "Thread a");
        Thread b = new Thread(job, "Thread b");

        int oldPriority = a.getPriority();
        int newPriority = Math.min(oldPriority+1,
                Thread.MAX_PRIORITY);
        a.setPriority(newPriority);

        System.out.println(oldPriority);
        System.out.println(newPriority);

        a.start();
        b.start();
    }
}