/*
 * Demonstrates coordination between two threads using a semaphore. ThreadA starts ThreadB.
 * ThreadA waits for ThreadB to complete, then ThreadB completes its own run method.
 */

package com.concurrent.semaphore;

public class ThreadRunner {

	public static void main(String[] args) {
		new ThreadA(new WaitNotifySemaphore(1)).start();
	}
}
