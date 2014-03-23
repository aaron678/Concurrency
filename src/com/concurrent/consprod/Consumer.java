package com.concurrent.consprod;

import static java.util.logging.Level.SEVERE;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

public class Consumer implements Runnable{
	private BlockingQueue<Integer> buffer;
	static private Logger logger = Logger.getLogger(Consumer.class.getName());

	Consumer (BlockingQueue<Integer> buffer){
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		for (int i=1; i<=100; ++i){	
			try {
				System.out.println("Sold widget #" + buffer.take());
				Thread.sleep(12);
			} catch (InterruptedException e) {
				logger.log(SEVERE, null, e);
			}
		}	
	}
}
