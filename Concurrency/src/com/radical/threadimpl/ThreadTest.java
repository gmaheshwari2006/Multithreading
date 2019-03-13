/**
 * 
 */
package com.radical.threadimpl;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("waiting");
		for (int i = 0; i < 200; i++) {
			System.out.println("My runnable name is Ganesh"
					+ Thread.currentThread().getName());
		}
		
	}

}

class MyThread extends Thread {

	public MyThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void run() {
		/*for (int i = 0; i < 200000; i++) {
			System.out.println("My name is gaurav"
					+ Thread.currentThread().getName());
			
		}*/
		System.out.println("my thread is running");
		MyRunnable r1 = new MyRunnable();
		Thread t4 = new Thread(r1, "runnable 10");
		
		try {
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t4.start();
		
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		for (int i = 0; i < 200; i++) {
			System.out.println("My name is gaurav"
					+ Thread.currentThread().getName());
			
			System.out.println(Thread.currentThread().getPriority());
			
		}
	}
}

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread("thread 1");
		MyThread t2 = new MyThread("thread 2");
		Thread t3 = new Thread(t1, "Thread3");
		t3.setPriority(8);
		t3.start();
		//t1.start();
		//t2.start();
		try {
			t1.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// t1.run();

		System.out.println("Runnable implementation: ");

		MyRunnable r1 = new MyRunnable();
		Thread t4 = new Thread(r1, "runnable 1");
//		t4.start();
		

		MyRunnable r2 = new MyRunnable();
		Thread t5 = new Thread(r2, "runnable 2");
//		t5.start();
//		t5.start();
	}

}
