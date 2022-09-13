package com.luxoft.bank.service;

import com.luxoft.bank.domain.Email;
import com.luxoft.bank.domain.Queue;
import com.luxoft.bank.exceptions.BankException;

import java.io.Serializable;

import static com.luxoft.tutor.Logger.log;

public class EmailService implements Runnable, Serializable {
    private final Queue<Email> emailQueue = new Queue<>();
    private final transient Thread thread;
    private int emailCounter = 0;
    private volatile boolean close;

    public EmailService() {
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        while (true) {
            if (!close) {
                Email email = emailQueue.get();

                increase(email);

                synchronized (emailQueue) {
                    try {
                        emailQueue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                return;
            }
        }
    }

    public void close() {
        close = true;
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    private void increase(Email email) {
        if ((email != null)) {
            emailCounter++;
            log(String.format("%s has been sent", email));
        }
    }

    public int getEmailCounter() {
        return emailCounter;
    }

    public void sendNotificationEmail(Email email) throws BankException {
        if (!close) {
            emailQueue.add(email);
            synchronized (emailQueue) {
                emailQueue.notifyAll();
            }
        } else {
            throw new BankException("Email not sent");
        }
    }
}
