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

    public int decimalValue() {
        return 0;
    }

    @Override
    public void getById(int id) {

    }

    @Override
    public void getAll() {

    }
}
