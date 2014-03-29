package com.concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class WaitNotifySemaphore  extends Semaphore {

	private static final long serialVersionUID = 1L;

	public WaitNotifySemaphore(int permits) {
		super(permits);

	}

	public WaitNotifySemaphore(int permits, boolean fair) {
		super(permits, fair);
	}

	synchronized public void doWait(){
		try {
			this.acquire();
			this.wait(5000);
		} catch (InterruptedException e) {
			// do nothing
		}
	}

	synchronized public void doNotify(){
		this.release();
		this.notify();
	}
}
