package com.luxoft.bank.domain;

import com.luxoft.bank.annotations.ActiveRecordEntity;
import com.luxoft.bank.exceptions.NotEnoughFundsException;
import com.luxoft.bank.exceptions.OverdraftLimitExceededException;

@ActiveRecordEntity(tableName = "CHECKING_ACCOUNT", columnKeyName = "id")
public class CheckingAccount extends AbstractAccount {
	
	private double overdraft;

	public CheckingAccount(int id, double balance, double overdraft) {
		super(id, balance);
		if (overdraft < 0) {
			throw new IllegalArgumentException("Cannot create an account with a starting negative overdraft");
		}
		this.overdraft = overdraft;
	}
	
	@Override
    public void withdraw(double value) throws OverdraftLimitExceededException{
        try {
            super.withdraw(value);
        } catch (NotEnoughFundsException notEnoughFundsException) {
            throw new OverdraftLimitExceededException(notEnoughFundsException, overdraft);
        }
    }

	public double getOverdraft() {
		return overdraft;
	}
	
	public double maximumAmountToWithdraw(){
        return getBalance() + overdraft;
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
