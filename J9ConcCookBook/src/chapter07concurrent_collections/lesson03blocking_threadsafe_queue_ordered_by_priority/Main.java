package chapter07concurrent_collections.lesson03blocking_threadsafe_queue_ordered_by_priority;

import java.util.concurrent.PriorityBlockingQueue;

public class Main {

	public static void main(String[] args) {
		PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();
		Thread[] taskThread = new Thread[5];
		for (int i = 0; i < taskThread.length; i++) {
			Task task = new Task(i, queue);
			taskThread[i] = new Thread(task);
		}
		for (int i = 0; i < taskThread.length; i++) {
			taskThread[i].start();
		}
		for (int i = 0; i < taskThread.length; i++) {
			try {
				taskThread[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Main: Queue Size: %d\n", queue.size());
		for (int i = 0; i < taskThread.length * 1000; i++) {
			Event event = queue.poll();
			System.out.printf("Thread %s: Priority %d\n", event.getThread(), event.getPriority());
		}
		System.out.printf("Main: Queue Size: %d\n", queue.size());
		System.out.println("Main: End of the program");
	}

}
