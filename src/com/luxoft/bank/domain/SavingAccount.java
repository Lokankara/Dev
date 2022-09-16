package com.luxoft.bank.domain;

import com.luxoft.bank.annotations.ActiveRecordEntity;

@ActiveRecordEntity(tableName = "SAVING_ACCOUNT", columnKeyName = "id")
public class SavingAccount extends AbstractAccount {
    public SavingAccount(int id, double balance) {
        super(id, balance);
    }

    public double maximumAmountToWithdraw() {
        return getBalance();
    }

    @Override
    public String toString() {
        return String.format("Saving account %d, balance: %.2f", getId(), balance);
    }

    @Override
    public void getById(int id) {
        
    }

    @Override
    public void getAll() {

    }
}
