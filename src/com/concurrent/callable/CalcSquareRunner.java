/*
 * A Callable example which returns Void. A Void return type makes a Callable behave 
 * like a Runnable, in that you don't care about the actual value of the 
 * Future, only that it is done.
 * 
 * Use case- you want a Runnable but you would like the run() method to throw a 
 * checked exception which it can't do.
 * So you use a Callable, have the call() method throw the checked exception 
 * and return Void.
 */

package com.concurrent.callable;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CalcSquareRunner {

	public static void main(String[] args) {
		System.out.println("Begin CalcSquareRunner");
		
		ExecutorService ftPool = Executors.newFixedThreadPool(10);
		
		List<Future<Void>> workBuffer = new ArrayList<Future<Void>>();
		
		for (int i=1; i<=10; ++i){
			Callable<Void> calcSquareFut = new CalcSquareCallable(i);
			Future<Void> futureResult = ftPool.submit(calcSquareFut);
			workBuffer.add(futureResult);
		}
		
// Wait until all futures are done and then shutdown pool.
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) { }
		} while (!allDone(workBuffer));
		
		ftPool.shutdown();
		
		try {
			ftPool.awaitTermination(10, SECONDS);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("End CalcSquareRunner");
	}
	
	private static boolean allDone(List<Future<Void>> workBuffer){
		for (Future<Void> f : workBuffer){
			if (!f.isDone())
				return false;
		}
		return true;
	}
}
