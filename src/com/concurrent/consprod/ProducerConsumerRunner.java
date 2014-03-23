package com.concurrent.consprod;

import static java.util.concurrent.TimeUnit.SECONDS;
import static java.util.logging.Level.SEVERE;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

public class ProducerConsumerRunner {
	static private Logger logger = Logger.getLogger(ProducerConsumerRunner.class.getName());
	static {logger.info("Begin ProducerConsumerRunner");}
	
	public static void main(String[] args){
		BlockingQueue<Integer> buffer = new LinkedBlockingQueue<Integer>(); //LinkedBQ is not bounded
		
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		
		threadPool.execute(new Producer(buffer));
		threadPool.execute(new Consumer(buffer));

		threadPool.shutdown();
		
		try {
			threadPool.awaitTermination(10, SECONDS);
		} catch (InterruptedException e) {
			logger.log(SEVERE, null, e);
			Thread.currentThread().interrupt();
		}
			
		}
	}

