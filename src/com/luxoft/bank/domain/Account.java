package com.luxoft.bank.domain;

import com.luxoft.bank.exceptions.NotEnoughFundsException;

public interface Account {
	public void deposit(double amount);
	public void withdraw(double amount) throws NotEnoughFundsException;
	public int getId();
	public double getBalance();
	public double maximumAmountToWithdraw();
}
