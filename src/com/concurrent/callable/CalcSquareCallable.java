package com.concurrent.callable;

import java.util.concurrent.Callable;

public class CalcSquareCallable implements Callable<Void> {
	int i;
	
	public CalcSquareCallable(int i){
		this.i = i;
	}
	
	void doWork(int i) throws InterruptedException {
		if (i%5==0){
			Thread.sleep(5000); }
		else {
			Thread.sleep(1000);
		}
		System.out.println("square of " + i + ": " + i*i);
	}

	@Override
	public Void call() throws InterruptedException {
		doWork(i); // Represents work performed by 
                   // the callable and throws a checked exception
		           // which you don't want to squelch.
		
		return null;  // causes method to return Void
	}



}
