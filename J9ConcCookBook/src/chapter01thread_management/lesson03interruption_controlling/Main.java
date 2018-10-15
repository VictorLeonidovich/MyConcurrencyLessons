package chapter01thread_management.lesson03interruption_controlling;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		FileSearch searcher = new FileSearch("C:\\Windows", "explorer.exe");
		Thread thread = new Thread(searcher);
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

}
