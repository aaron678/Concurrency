Programs demonstrating various Java features.

Under src/com/concurrent/ there are the following programs:
	forkjoin- calculates a partial sum of a sequence using the forkjoin framework to create worker threads 
                    which calculate and then aggregate the individual sums.
        consprod- a consumer producer example using the Executor service to create threads and a BlockingQueue 
                    to coordinate work between the threads.
	
        semaphore- ThreadA starts ThreadB and waits until ThreadB completes its run method. ThreadA completes its run method.
                     interthread communication is accomplished by a java.util.concurrent.Semaphore.
