package com.concurrent.semaphore;

public class ThreadB extends Thread {
	private WaitNotifySemaphore semaphore;
	
	ThreadB(WaitNotifySemaphore semaphore){
		this.semaphore= semaphore;
	}
	
	public void run(){
		System.out.println("ThreadB beginning run method.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) { 		}
		System.out.println("ThreadB releasing semaphore token and calling notify() on ThreadA.");
		semaphore.doNotify();
		System.out.println("ThreadB completing run method.");
		
	}
}
