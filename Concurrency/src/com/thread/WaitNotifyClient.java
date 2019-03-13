package com.thread;

class MyWaitThread implements Runnable {
	MyWaitNotify waitNotify = null;

	public MyWaitThread() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyWaitThread(MyWaitNotify waitNotify) {
		super();
		this.waitNotify = waitNotify;
	}

	@Override
	public void run() {
		waitNotify.doWait();
	}

}

class MyNotifyThread implements Runnable {
	MyWaitNotify waitNotify = null;

	public MyNotifyThread() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyNotifyThread(MyWaitNotify waitNotify) {
		super();
		this.waitNotify = waitNotify;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitNotify.doNotify();
	}

}

public class WaitNotifyClient {
	MyWaitNotify waitNotify = new MyWaitNotify();

	MyWaitThread waitThread = new MyWaitThread(waitNotify);
	MyWaitThread waitThread1 = new MyWaitThread(waitNotify);

	MyNotifyThread notifyThread = new MyNotifyThread(waitNotify);

	public static void main(String arg[]) {
		WaitNotifyClient client = new WaitNotifyClient();
		client.executeProcess();
	}

	public void executeProcess() {
		Thread t1 = new Thread(waitThread);
		Thread t3 = new Thread(waitThread);
		Thread t2 = new Thread(notifyThread);
		t1.start();
		t3.start();
		t2.start();
		
	}
}
