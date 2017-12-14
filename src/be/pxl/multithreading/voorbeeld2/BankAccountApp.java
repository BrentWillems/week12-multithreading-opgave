package be.pxl.multithreading.voorbeeld2;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccountApp {
	public static void main(String[] args) {
		BankAccount account = new BankAccount("12345-678", new AtomicInteger(10000));
		
		Thread thread = new Thread(() -> account.deposit(100));
		Thread thread2 = new Thread(() -> account.withdraw(200));
		thread.start();
		thread2.start();
		try {
			thread.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			thread2.join();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(account.getBalance());
		
	}
}
