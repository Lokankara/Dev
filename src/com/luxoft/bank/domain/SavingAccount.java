package com.luxoft.bank.domain;


public class SavingAccount extends AbstractAccount {
	public SavingAccount(int id, double balance) {
		super(id, balance);
	}
	
	public double maximumAmountToWithdraw(){
        return getBalance();
    }

    public int decimalValue() {
        return 0;
    }
}
