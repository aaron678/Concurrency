package com.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;

//Calculates the partial sum of a sequence from 0 to the value assigned to partialSumOf.
// Ex: the partial sum of 3 is 10 or the total of the following lines
// 3 + 2 + 1 = 6
// 2 + 1 = 3
// 1 = 1
// ------------- 
// 10
public class PartialSumRunner {
	// http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ForkJoinPool.html
	// Should be static as only one pool should be created per program.
	// No need to explicitly shutdown the pool on exiting.
	static ForkJoinPool fjp = new ForkJoinPool();

	public static void main(String[] args) {
		int partialSumOf = 3;
		Integer partialSum = fjp.invoke(new DistributeWorkTask(partialSumOf));
		System.out.println("The partial sum of 0 to " + partialSumOf + " is " + partialSum);
	}
}
