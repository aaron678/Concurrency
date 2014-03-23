package com.concurrent.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import com.concurrent.forkjoin.PartialSumTask;

public class DistributeWorkTask extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	
	int partialSum = 0;
	
	DistributeWorkTask (int ps){
		this.partialSum = ps;
	}
	

	@Override
	protected Integer compute() {
		int result = 0;
		List <RecursiveTask<Integer>> workerTasks = new ArrayList<>();
		for (int i = 1; i <= this.partialSum; ++i){
			PartialSumTask workerTask = new PartialSumTask(i);
			workerTasks.add(workerTask);
			workerTask.fork();
		}
		
		for (RecursiveTask<Integer> workerTask : workerTasks){
			result += workerTask.join();
		}
		
		return result;
	}

}
