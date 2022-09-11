package com.luxoft.bank.service;

import com.luxoft.bank.domain.Account;
import com.luxoft.bank.domain.Bank;
import com.luxoft.bank.domain.Client;
import com.luxoft.bank.exceptions.ClientExistsException;

import java.io.*;
import java.util.List;

public class BankService {
    private static String serialization;

    public BankService(String serialization) {
        BankService.serialization = serialization;
    }

    public static void addBank(Bank bank) {

        if (serialization != null) {
            try (FileOutputStream file =
                         new FileOutputStream(serialization);

                 ObjectOutputStream output =
                         new ObjectOutputStream(file)) {

                output.writeObject(bank);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Bank readBank() {
        //TODO Read Bank
        if (serialization != null) {

            try (FileInputStream file = new FileInputStream(serialization);

                 ObjectInputStream input = new ObjectInputStream(file)) {

                return (Bank) input.readObject();

            } catch (Exception e) {

                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public static void addClient(Bank bank, Client client) throws ClientExistsException {
        bank.addClient(client);
        addBank(bank);
    }

    public static Client readClient(String username) throws ClientExistsException {
        //TODO Read Client
        Bank bank = readBank();

        List<Client> clients = bank.getClients();

        return clients.stream()
                .filter(client -> client.getName().equals(username))
                .findFirst()
                .orElse(null);
    }

    public static void printMaximumAmountToWithdraw(Bank bank) {
        System.out.format("%nPrint maximum amount to withdraw for all clients%n");

        StringBuilder result = new StringBuilder();
        for (Client client : bank.getClients()) {
            result.append("Client: ")
                    .append(client)
                    .append("\n");
            int i = 1;
            for (Account account : client.getAccounts()) {
                result.append("Account nr. ")
                        .append(i++)
                        .append(", maximum amount to withdraw: ")
                        .append(Math.round(account.maximumAmountToWithdraw() * 100) / 100d)
                        .append("\n");
            }
        }
        System.out.println(result);
    }
}
