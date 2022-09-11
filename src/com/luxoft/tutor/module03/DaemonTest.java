package com.luxoft.tutor.module03;

public class DaemonTest {
    public static void main(String[] args) {
        new WorkerThread().start();
        try {
            Thread.sleep(7500);
        } catch (InterruptedException e) 
        {
        	
        }
        System.out.println("Main Thread ending") ;
    }
}
