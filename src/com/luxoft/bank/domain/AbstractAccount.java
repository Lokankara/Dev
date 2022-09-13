package com.luxoft.bank.domain;

import com.luxoft.bank.annotations.ActiveRecord;
import com.luxoft.bank.exceptions.NotEnoughFundsException;

import java.util.Objects;

public abstract class AbstractAccount extends ActiveRecord implements Account  {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AbstractAccount)) return false;
		AbstractAccount that = (AbstractAccount) o;
		return id == that.id && Double.compare(that.balance, balance) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, balance);
	}
}
