package com.luxoft.tutor.module04;

public class Increment {
    private final ReadWriteLockTutor lock = new ReadWriteLockTutor();
    private int value;

    public void incrementValue() {
        lock.writeLock().lock();
        try {
            value++;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int getValue() {
        lock.readLock().lock();
        try {
            return value;
        } finally {
            lock.readLock().unlock();
        }
    }
}
