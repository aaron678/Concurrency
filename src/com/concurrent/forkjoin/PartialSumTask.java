package com.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;

public class PartialSumTask extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	
	int i;
	PartialSumTask (int i){
		this.i = i;
	}

	@Override
	protected Integer compute(){
		int sum = 0;
		for (int j = 1; j <= this.i; ++j){
			sum += j;
		}
		return sum;
	}
}
