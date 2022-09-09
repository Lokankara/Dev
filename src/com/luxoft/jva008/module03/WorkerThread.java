package com.luxoft.jva008.module03;

class WorkerThread extends Thread {

    /**
     * Try to set daemon flag to true or false and look
     * how the behavior will be changing.
     */
    public WorkerThread() {
        setDaemon(true);
    }

    public void run() {
        int count = 0;
        while (true) {
            System.out.println("Hello from Worker " + count++);
            try {
                sleep(5000);
            } catch (InterruptedException e) {

            }
        }
    }
}