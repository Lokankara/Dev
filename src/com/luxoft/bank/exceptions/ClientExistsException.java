package com.luxoft.bank.exceptions;

public class ClientExistsException extends BankException {
	private static final long serialVersionUID = -8368249553360028667L;

	public ClientExistsException(String message) {
		super(message);
	}

}
