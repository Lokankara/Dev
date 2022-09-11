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
    private boolean close;

    public EmailService() {
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        while (true) {
            if (close) {
                return;
            }
            Email email = emailQueue.get();

            if ((email != null)) {
                emailCounter++;
                log(email + " has been sent");
            }

            try {
                synchronized (emailQueue) {
                    emailQueue.wait();
                }
            } catch (InterruptedException e) {
                throw new IllegalArgumentException();
            }
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
        } else
            throw new BankException("Email not sent");
    }
}
