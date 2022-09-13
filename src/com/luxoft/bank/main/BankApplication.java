package com.luxoft.bank.main;

import com.luxoft.bank.domain.Account;
import com.luxoft.bank.domain.Bank;
import com.luxoft.bank.domain.CheckingAccount;
import com.luxoft.bank.domain.Client;
import com.luxoft.bank.domain.Gender;
import com.luxoft.bank.domain.SavingAccount;
import com.luxoft.bank.exceptions.ClientExistsException;
import com.luxoft.bank.exceptions.NotEnoughFundsException;
import com.luxoft.bank.exceptions.OverdraftLimitExceededException;
import com.luxoft.bank.service.BankService;
import com.luxoft.bank.service.EmailService;

public class BankApplication {

    private static Bank bank;

    public static void main(String[] args) {
        EmailService emailService = new EmailService();
        bank = new Bank();
        modifyBank();
        printBalance();
        BankService.printMaximumAmountToWithdraw(bank);
        bank.close();
    }

    private static void modifyBank() {
        Client client1 = new Client("John", Gender.MALE);
        Account account1 = new SavingAccount(1, 100);
        Account account2 = new CheckingAccount(2, 100, 20);
        client1.addAccount(account1);
        client1.addAccount(account2);

        try {
            BankService.addClient(bank, client1);
        } catch (ClientExistsException e) {
            System.out.format("Cannot add an already existing client: %s%n", client1.getName());
        }

        account1.deposit(100);
        try {
            account1.withdraw(10);
        } catch (OverdraftLimitExceededException e) {
            System.out.format("Not enough funds for account %d, balance: %.2f, overdraft: %.2f, tried to extract amount: %.2f%n", e.getId(), e.getBalance(), e.getOverdraft(), e.getAmount());
        } catch (NotEnoughFundsException e) {
            System.out.format("Not enough funds for account %d, balance: %.2f, tried to extract amount: %.2f%n", e.getId(), e.getBalance(), e.getAmount());
        }

        try {
            account2.withdraw(90);
        } catch (OverdraftLimitExceededException e) {
            System.out.format("Not enough funds for account %d, balance: %.2f, overdraft: %.2f, tried to extract amount: %.2f%n", e.getId(), e.getBalance(), e.getOverdraft(), e.getAmount());
        } catch (NotEnoughFundsException e) {
            System.out.format("Not enough funds for account %d, balance: %.2f, tried to extract amount: %.2f%n", e.getId(), e.getBalance(), e.getAmount());
        }

        try {
            account2.withdraw(100);
        } catch (OverdraftLimitExceededException e) {
            System.out.format("Not enough funds for account %d, balance: %.2f, overdraft: %.2f, tried to extract amount: %.2f%n", e.getId(), e.getBalance(), e.getOverdraft(), e.getAmount());
        } catch (NotEnoughFundsException e) {
            System.out.format("Not enough funds for account %d, balance: %.2f, tried to extract amount: %.2f%n", e.getId(), e.getBalance(), e.getAmount());
        }

        try {
            BankService.addClient(bank, client1);
        } catch (ClientExistsException e) {
            System.out.format("Cannot add an already existing client: %s%n", client1);
        }
    }

    private static void printBalance() {
        System.out.format("%nPrint balance for all clients%n");
        for (Client client : bank.getClients()) {
            System.out.println("Client: " + client);
            for (Account account : client.getAccounts()) {
                System.out.format("Account %d : %.2f%n", account.getId(), account.getBalance());
            }
        }
    }

}
