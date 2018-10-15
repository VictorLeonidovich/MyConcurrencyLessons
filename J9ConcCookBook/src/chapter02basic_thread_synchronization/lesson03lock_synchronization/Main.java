package chapter02basic_thread_synchronization.lesson03lock_synchronization;

public class Main {

	public static void main(String[] args) {
		System.out.printf("Running example with fair-mode = false\n");
		testPrintQueue(false);
		System.out.printf("Running example with fair-mode = true\n");
		testPrintQueue(true);

	}

	private static void testPrintQueue(boolean fairMode) {
		PrintQueue printQueue = new PrintQueue(fairMode);
		Thread[] thread = new Thread[10];
		for (int i = 0; i < thread.length; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread " + i);
		}
		for (int i = 0; i < thread.length; i++) {
			thread[i].start();
		}
		for (int i = 0; i < thread.length; i++) {
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
