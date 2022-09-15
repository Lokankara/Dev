package com.luxoft.bank.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    private final String name;
    private final Gender gender;
    private List<Account> accounts = new ArrayList<Account>();
    private final String city;
    private final LocalDate birthday;

    public Client(String name, Gender gender, String city) {
        this.name = name;
        this.gender = gender;
        this.city = city;
        this.birthday = LocalDate.now();
    }

    public Client(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.accounts = new ArrayList<>();
        this.birthday = LocalDate.now();
        this.city = "";
    }

    public Client(String name, Gender gender, LocalDate date) {
        this.name = name;
        this.gender = gender;
        this.birthday = date;
        this.city = "";
    }

    public void addAccount(final Account account) {
        accounts.add(account);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getCity() {
        return city;
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

    public long daysUntilBirthday() {
        LocalDate today = LocalDate.now();
        long daysInBetween = ChronoUnit.DAYS.between(today, LocalDate.of(today.getYear(), birthday.getMonth(), birthday.getDayOfMonth()));
        if (daysInBetween < 0) {
            daysInBetween += 365;
        }
        return daysInBetween;
    }

    public int getBirthdayMonth() {
        return birthday.getMonth().getValue();
    }
}
