package com.luxoft.bank.domain;

import com.luxoft.bank.exceptions.NotEnoughFundsException;

public interface Account {
	void deposit(double amount);
	void withdraw(double amount) throws NotEnoughFundsException;
	int getId();
	double getBalance();
	double maximumAmountToWithdraw();
	int decimalValue();
}
