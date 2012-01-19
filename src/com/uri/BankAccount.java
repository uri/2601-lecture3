package com.uri;

public class BankAccount {
	
	private int balance;

	BankAccount() {
		this(0);
	}
	
	BankAccount(int amount) {
		if (amount < 0) {
			amount = 0;
		}
		
		this.balance = amount;
	}
	
	int withdraw(int amount) {
		if (amount < 0) return 0;
		if (amount > balance) return 0;
		balance -= amount;
		return amount;
	}
	
	void deposite (int amount) {
		if (amount < 0) return;
		balance += amount;
	}
	
	
	int getBalance() {
		return balance;
	}
	
}
