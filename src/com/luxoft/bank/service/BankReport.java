package com.luxoft.bank.service;

import com.luxoft.bank.domain.Account;
import com.luxoft.bank.domain.Bank;
import com.luxoft.bank.domain.Client;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

public interface BankReport {

    int getNumberOfClients(Bank bank);

    int getNumberOfAccounts(Bank bank);

    SortedSet getClientsSorted(Bank bank);

    double getTotalSumInAccounts(Bank bank);

    SortedSet getAccountsSortedBySum(Bank bank);

    double getBankCreditSum(Bank bank);

    Map<Client, Collection<Account>> getCustomerAccounts(Bank bank);

    Map<String, List<Client>> getClientsByCity(Bank bank);

}
