package chapter04thread_executors.lesson01thread_executor_creation;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private final Date initDate;
	private final String name;

	public Task(String taskName) {
		this.initDate = new Date();
		this.name = taskName;
	}

	@Override
	public void run() {
		System.out.printf("%s: Task %s: Created on: %s\n", Thread.currentThread().getName(), name, initDate);
		System.out.printf("%s: Task %s: Started on: %s\n", Thread.currentThread().getName(), name, new Date());
		try {
			Long duration = (long) (Math.random() * 2);
			System.out.printf("%s: Task %s: Doing a task during %d seconds\n", Thread.currentThread().getName(), name,
					duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s: Task %s: Finished on: %s\n", Thread.currentThread().getName(), name, new Date());
	}

}
