package chapter08customizing_concurrency_classes.lesson05scheduled_thread_pool;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("Task: Begin.");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Task: End.");
	}

}
