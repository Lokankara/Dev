package com.luxoft.bank.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {

    private final String name;
    private final Gender gender;
    private List<Account> accounts = new ArrayList<Account>();

    public Client(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public void addAccount(final Account account) {
        accounts.add(account);
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    public String getClientGreeting() {
        if (gender != null) {
            return gender.getGreeting() + " " + name;
        } else {
            return name;
        }
    }

    @Override
    public String toString() {
        return getClientGreeting();
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
