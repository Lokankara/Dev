package com.luxoft.bank.tests;

import com.luxoft.bank.domain.*;
import com.luxoft.bank.exceptions.ClientExistsException;
import com.luxoft.bank.exceptions.NotEnoughFundsException;
import com.luxoft.bank.service.BankReportStreams;
import com.luxoft.bank.service.BankService;
import com.luxoft.bank.service.StreamBankReport;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TestReport {
    @Test
    public void testBankReport() throws ClientExistsException, NotEnoughFundsException {
        Bank bank = new Bank();
        Client client1 = new Client("John", Gender.MALE, "New York");
        Client client2 = new Client("Michael", Gender.MALE, "London");
        Client client3 = new Client("Anna", Gender.FEMALE, "Berlin");

        Account account1 = new SavingAccount(1, 100);
        Account account2 = new CheckingAccount(2, 100, 20);
        client1.addAccount(account1);
        client1.addAccount(account2);

        BankService.addClient(bank, client1);
        BankService.addClient(bank, client2);
        BankService.addClient(bank, client3);

        account1.deposit(100);

        account1.withdraw(10);
        account2.withdraw(90);

        BankReportStreams bankReport = new StreamBankReport();

        assertEquals(3,  bankReport.getNumberOfClients(bank));
        assertEquals(2, bankReport.getNumberOfAccounts(bank));

        HashSet<Client> treeSet = new HashSet<>();
        treeSet.add(client3);
        treeSet.add(client1);
        treeSet.add(client2);
        assertEquals(treeSet, bankReport.getClientsSorted(bank));

        assertEquals(200.0, bankReport.getTotalSumInAccounts(bank), 0.0001);

        HashSet<Account> accountsSortedBySum = new HashSet<>();
        accountsSortedBySum.add(account2);
        accountsSortedBySum.add(account1);
        assertEquals(accountsSortedBySum, bankReport.getAccountsSortedBySum(bank));

        double bankCreditSum = bankReport.getBankCreditSum(bank);

        assertEquals(20.0, bankCreditSum, 0.0001);

        Map<Client, Collection<Account>> map = new HashMap<>();
        map.put(client1, client1.getAccounts());
        map.put(client2, client2.getAccounts());
        map.put(client3, client3.getAccounts());

        assertEquals(map, bankReport.getCustomerAccounts(bank));

        Map <String, List<Client>> mapClientByCity = new HashMap<>();
        ArrayList<Client> arrayList1 = new ArrayList<>();
        arrayList1.add(client1);
        mapClientByCity.put("New York", arrayList1);
        ArrayList<Client> arrayList2 = new ArrayList<>();
        arrayList2.add(client2);
        mapClientByCity.put("London", arrayList2);
        ArrayList<Client> arrayList3 = new ArrayList<>();
        arrayList3.add(client3);
        mapClientByCity.put("Berlin", arrayList3);

        assertEquals(mapClientByCity, bankReport.getClientsByCity(bank));
    }
    //TODO Credit test
}
