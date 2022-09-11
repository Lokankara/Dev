package com.luxoft.bank.tests;

import com.luxoft.bank.domain.Client;
import com.luxoft.bank.domain.Email;
import com.luxoft.bank.domain.Gender;
import com.luxoft.bank.exceptions.BankException;
import com.luxoft.bank.service.EmailService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestEmail {
    private static final int NO_EMAILS = 20;
    private Client client;
    private Client to;

    @Before
    public void setup() {
        client = new Client("Andrew", Gender.MALE);
        to = new Client("Brian", Gender.MALE);
    }

    @Test
    public void testSendMail() throws InterruptedException {

        EmailService emailService = new EmailService();
        for (int i = 0; i < NO_EMAILS; i++) {
            try {
                emailService.sendNotificationEmail(
                        new Email(client, List.of(to), "Email Service")
                );
            } catch (BankException e) {
                e.printStackTrace();
            }
            Thread.sleep(100);
        }

        assertEquals(NO_EMAILS, emailService.getEmailCounter());

    }
}