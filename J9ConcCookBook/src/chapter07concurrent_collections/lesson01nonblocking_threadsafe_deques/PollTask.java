package chapter07concurrent_collections.lesson01nonblocking_threadsafe_deques;

import java.util.concurrent.ConcurrentLinkedDeque;

public class PollTask implements Runnable {
	private final ConcurrentLinkedDeque<String> list;

	public PollTask(ConcurrentLinkedDeque<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {
			System.out.println("pollFirst: " + list.pollFirst());
			System.out.println("pollLast: " + list.pollLast());
		}
	}

}
