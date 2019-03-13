package com.thread;

public class MyWaitNotify {
	MonitorObject myMonitorObject = new MonitorObject();

	public void doWait() {
		synchronized (myMonitorObject) {
			try {
				System.out.println("Thread in do wait method");
				myMonitorObject.wait();
				System.out.println("Thread come out of waiting state");
			} catch (InterruptedException e) {

			}
			System.out.println("Thread is awakened");
		}
	}

	public void doNotify() {
		synchronized (myMonitorObject) {
			System.out.println("Notify signal for Thread");
			myMonitorObject.notifyAll();
		}
	}
}
