package com.radical.threadimpl;

class Account {

	public int balance = 50;

	public int getBalance() {
		return balance;
	}

	public void withdraw(int amount) {
		balance = balance - amount;
	}
}

public class AccountDanger implements Runnable {
	private  Account  acct = new Account();
	private  Account acct1 = new Account();
	public static void main(String[] args) {
		AccountDanger r = new AccountDanger();
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		one.setName("Fred");
		two.setName("Lucy");

		one.start();
		two.start();
	}

	public void run() {
		// Account acct = new Account();
		for (int x = 0; x < 5; x++) {
			makeWithdrawal(10);
			// makeWithdrawal(acct, 10);
			if (acct.getBalance() < 0) {
				System.out.println("account is overdrawn!");
			}
		}
	}

	private void makeWithdrawal(int amt) {
		// synchronized private void makeWithdrawal(Account acct2, int amt) {
		synchronized ("dfjdskljf") {
			if (acct.getBalance() >= amt) {
				System.out.println(Thread.currentThread().getName()
						+ " is going to withdraw");
				try {
					Thread.sleep(500);
				} catch (InterruptedException ex) {
				}
				acct.withdraw(amt);
				System.out.println(Thread.currentThread().getName()
						+ " completes the withdrawal");
			} else {
				System.out.println("Not enough in account for "
						+ Thread.currentThread().getName() + " to withdraw "
						+ acct.getBalance());
			}
		}
	}
	
	public static void setName() throws ClassNotFoundException{
		Class cl =  Class.forName("AccountDanger"); 
//	synchronized (AccountDanger.class){
		synchronized (cl){
		System.out.println("name");
		}
	} 
}
