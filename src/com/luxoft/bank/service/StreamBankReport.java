package com.luxoft.bank.service;

import com.luxoft.bank.domain.Account;
import com.luxoft.bank.domain.Bank;
import com.luxoft.bank.domain.Client;

import java.util.*;
import java.util.stream.Collectors;

public class StreamBankReport implements BankReportStreams {

    @Override
    public int getNumberOfClients(Bank bank) {
        return bank.getClients().size();
    }

    @Override
    public int getNumberOfAccounts(Bank bank) {
        return bank.getClients()
                .stream()
                .map(client -> client.getAccounts().size())
                .mapToInt(size -> size)
                .sum();
    }

    @Override
    public SortedSet<Client> getClientsSorted(Bank bank) {
        return bank.getClients()
                .stream()
                .collect(Collectors.toCollection(() ->
                        new TreeSet<>(Comparator.comparing(Client::getName))));
    }

    @Override
    public double getTotalSumInAccounts(Bank bank) {
        return bank.getClients()
                .stream()
                .map(Client::getAccounts)
                .flatMap(Collection::stream)
                .mapToDouble(Account::getBalance)
                .sum();
    }

    @Override
    public SortedSet<Account> getAccountsSortedBySum(Bank bank) {

        TreeSet<Account> accountTreeSet = new TreeSet<>(Comparator.comparingDouble(Account::getBalance));

        bank.getClients().stream().map(Client::getAccounts).forEach(accountTreeSet::addAll);

        return accountTreeSet;
    }

    @Override
    public double getBankCreditSum(Bank bank) {

        return bank.getClients()
                .stream()
                .mapToDouble(client -> client.getAccounts()
                        .stream()
                        .filter(account -> account.getBalance() < 0)
                        .mapToDouble(account -> -account.getBalance())
                        .sum())
                .sum();
    }

    @Override
    public Map<Client, Collection<Account>> getCustomerAccounts(Bank bank) {

        return bank.getClients()
                .stream()
                .collect(Collectors.toMap(client -> client,
                        Client::getAccounts, (a, b) -> b));
    }

    @Override
    public Map<String, List<Client>> getClientsByCity(Bank bank) {
        return bank.getClients().stream().collect(Collectors.groupingBy(Client::getCity));
    }
}
//TODO Credit test