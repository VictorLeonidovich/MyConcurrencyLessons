package chapter01thread_management.lesson04slipping_resuming;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ConsoleClock clock = new ConsoleClock();
		Thread thread = new Thread(clock);
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

}
