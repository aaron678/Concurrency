package com.concurrent.semaphore;

public class ThreadA extends Thread {
	private WaitNotifySemaphore semaphore;

	ThreadA(WaitNotifySemaphore semaphore){
		this.semaphore= semaphore;
	}
	public void run(){
		System.out.println("ThreadA beginning run method.");
		System.out.println("ThreadA creating and starting ThreadB");
		new ThreadB(this.semaphore).start();
		System.out.println("ThreadA acquiring semaphore token and waiting for ThreadB to complete.");
		semaphore.doWait();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) { 	}
		System.out.println("ThreadA completing run method.");

	}
}
