package com.uri;

import android.util.Log;

public class BankThread implements Runnable {

	BankAccount receiver;
	BankAccount giver;
	Runnable postRunnable;
	Lecture3newActivity activity;
	int sleepDelay;
	String name;
	
	int maxWithdraw;
	int ammountPerWithdraw;

	BankThread(String name, BankAccount receiver, BankAccount giver,
			Lecture3newActivity activity, int maxWithdraw,int amountPerWithdraw, int delay) {
		this.receiver = receiver;
		this.giver = giver;
		this.activity = activity;
		this.sleepDelay = delay;
		this.name = name;
		this.maxWithdraw = maxWithdraw;
		this.ammountPerWithdraw = amountPerWithdraw;
	}

	public void run() {
		synchronized (receiver) {
			synchronized (giver) {
				
				int stopCondition = 0;
				Log.i("bank", name + " is $" + receiver.getBalance() + ".");
				// Take money
				while (stopCondition < maxWithdraw) {
					// Withdraw
					int withdrawNum = giver.withdraw(ammountPerWithdraw);
					// Deposite
					receiver.deposite(withdrawNum);
					// Stop counter
					stopCondition += withdrawNum;

					// Sleep for a bit
					try {
						Thread.sleep(sleepDelay);
					} catch (InterruptedException e) {
					}

					// Display GUI changes
					activity.getHandler().post(new Runnable() {
						public void run() {
							activity.getField1().setText("" + giver.getBalance());
							activity.getField2().setText("" + receiver.getBalance());
						}
					});
				}
				
				Log.i("bank", name + "has stopped receiving.");
			}
		}

	}

}
