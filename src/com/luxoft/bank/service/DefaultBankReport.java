package com.luxoft.bank.service;

import com.luxoft.bank.domain.Account;
import com.luxoft.bank.domain.Bank;
import com.luxoft.bank.domain.CheckingAccount;
import com.luxoft.bank.domain.Client;

import java.util.*;
import java.util.stream.Collectors;

public class DefaultBankReport implements BankReport {
    @Override
    public int getNumberOfClients(Bank bank) {
        return bank.getClients().size();
    }

    @Override
    public int getNumberOfAccounts(Bank bank) {
        return bank.getClients()
                .stream()
                .mapToInt(client -> getNumberOfClients(bank))
                .sum();
    }

    @Override
    public SortedSet<Client> getClientsSorted(Bank bank) {
        return new TreeSet<>(bank.getClients());
    }

    @Override
    public double getTotalSumInAccounts(Bank bank) {
        return bank.getClients()
                .stream()
                .mapToDouble(client -> client.getAccounts()
                        .stream()
                        .mapToDouble(Account::getBalance)
                        .sum())
                .sum();
    }

    @Override
    public SortedSet<Account> getAccountsSortedBySum(Bank bank) {

        TreeSet<Account> sortedAccounts =
                new TreeSet<>(Comparator
                        .comparingDouble(Account::getBalance));

        bank.getClients()
                .stream()
                .map(Client::getAccounts)
                .forEach(sortedAccounts::addAll);

        return sortedAccounts;
    }

    @Override
    public double getBankCreditSum(Bank bank) {
        return bank.getClients()
                .stream()
                .mapToDouble(client -> client.getAccounts()
                        .stream()
                        .filter(CheckingAccount.class::isInstance)
                        .mapToDouble(Account::getBalance)
                        .sum())
                .sum();
    }

    @Override
    public Map<Client, Collection<Account>> getCustomerAccounts(Bank bank) {
        return bank.getClients()
                .stream()
                .collect(Collectors.toMap(client -> client, Client::getAccounts, (a, b) -> b));
    }

    @Override
    public Map<String, List<Client>> getClientsByCity(Bank bank) {
        Map<String, List<Client>> treeCity = new TreeMap<>();

        List<String> cities = bank.getClients()
                .stream()
                .map(Client::getCity)
                .collect(Collectors.toList());

        cities.forEach(city -> {
            List<Client> clients = bank.getClients()
                    .stream()
                    .filter(client -> Objects.equals(client.getCity(), city))
                    .collect(Collectors.toList());
            treeCity.put(city, clients);
        });
        return treeCity;
    }
}
