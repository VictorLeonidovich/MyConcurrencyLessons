package chapter03thread_synchronization_utilites.lesson01concurrent_access_control;

import java.util.Date;

public class Job implements Runnable {
	private PrintQueue printQueue;

	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}

	@Override
	public void run() {
		System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
		printQueue.printJob(new Object());
		System.out.printf("%s: The document has been printed: %s\n", Thread.currentThread().getName(), new Date());
	}

}
