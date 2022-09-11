package com.luxoft.bank.domain;

import com.luxoft.bank.exceptions.NotEnoughFundsException;

public abstract class AbstractAccount implements Account {
	private final int id;
	protected double balance;

	protected AbstractAccount(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	@Override
	public void deposit(final double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot deposit a negative amount");
		}
		this.balance += amount;
	}

	@Override
	public void withdraw(final double amount) throws NotEnoughFundsException {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot withdraw a negative amount");
		}
		
		if (amount > maximumAmountToWithdraw()) {
			throw new NotEnoughFundsException(id, balance, amount, "Requested amount exceeds the maximum amount to withdraw");
		}
		
		this.balance -= amount;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public double getBalance() {
		return balance;
	}
}
