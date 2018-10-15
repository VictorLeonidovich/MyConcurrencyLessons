package chapter01thread_management.lesson08thread_local_variables;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		System.out.println("-=UnsafeTask=-");
		UnsafeTask task1 = new UnsafeTask();
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(task1);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("-=SafeTask=-");
		SafeTask task2 = new SafeTask();
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(task2);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
