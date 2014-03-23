package com.concurrent.consprod;

import static java.util.logging.Level.SEVERE;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

public class Producer implements Runnable{
	private BlockingQueue<Integer> buffer;
	static private Logger logger = Logger.getLogger(Producer.class.getName());

	Producer (BlockingQueue<Integer> buffer){
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		for (int i=1; i<=100; ++i){
			System.out.println("Created widget #" + i);
			try {
				buffer.put(i);
				Thread.sleep(10);
			} catch (InterruptedException e) {
				logger.log(SEVERE, null, e);
			}		
		}		
	}
}
