package chapter04thread_executors.lesson07cancelling_a_task;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

	@Override
	public String call() throws Exception {
		while (true) {
			System.out.println("Task: Test");
			Thread.sleep(100);
		}

	}

}
