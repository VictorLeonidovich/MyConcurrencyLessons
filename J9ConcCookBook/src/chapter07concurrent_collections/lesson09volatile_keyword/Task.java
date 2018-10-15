package chapter07concurrent_collections.lesson09volatile_keyword;

import java.util.Date;

public class Task implements Runnable {
	private Flag flag;

	public Task(Flag flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		int i = 0;
		while (flag.flag) {
			i++;
		}
		System.out.printf("Task: Stopped %d - %s\n", i, new Date());
	}

}
