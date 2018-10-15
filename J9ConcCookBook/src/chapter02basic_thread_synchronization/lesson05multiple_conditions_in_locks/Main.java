package chapter02basic_thread_synchronization.lesson05multiple_conditions_in_locks;

public class Main {

	public static void main(String[] args) {
		FileMock mock = new FileMock(100, 10);
		Buffer buffer = new Buffer(20);
		Producer producer = new Producer(mock, buffer);
		Thread producerThread = new Thread(producer, "Producer");
		Consumer[] consumers = new Consumer[3];
		Thread[] consumerThreads = new Thread[3];
		for (int i = 0; i < consumers.length; i++) {
			consumers[i] = new Consumer(buffer);
			consumerThreads[i] = new Thread(consumers[i], "Consumer " + i);
		}
		producerThread.start();
		for (int i = 0; i < consumers.length; i++) {
			consumerThreads[i].start();
		}
	}

}
