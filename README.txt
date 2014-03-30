Programs demonstrating various Java features of the Java concurrency framework.

Under src/com/concurrent/ there are the following programs:
	forkjoin- Calculates a partial sum of a sequence using the forkjoin framework to create worker threads 
                    which calculate and then aggregate the individual sums.
        consprod- A consumer producer example using the Executor service to create threads and a BlockingQueue 
                    to coordinate work between the threads.
	
        semaphore- ThreadA starts ThreadB and waits until ThreadB completes its run method, then ThreadA completes its run method.
                     interthread communication is accomplished by java.util.concurrent.Semaphore.

        callable- A Callable example using the ExecutorService which returns the Void class, effectively imitating a Runnable
                     in that you only care that the thread has finished not the value of the future.
