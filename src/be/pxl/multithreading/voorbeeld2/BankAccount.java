package be.pxl.multithreading.voorbeeld2;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
	private AtomicInteger balance;
	private String accountNumber;
	
	public BankAccount(String accountNumber, AtomicInteger initialBalance) {
		this.accountNumber = accountNumber;
		this.balance = initialBalance;
	}
	
	public void deposit(int amount) {
		balance.getAndAdd(amount);
	}
	
	public void withdraw(int amount) {
		balance.getAndAdd(-amount);
	}
	
	public double getBalance() {
		return balance.get();
		
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
}
