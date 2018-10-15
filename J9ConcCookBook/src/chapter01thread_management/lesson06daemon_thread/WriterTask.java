package chapter01thread_management.lesson06daemon_thread;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class WriterTask implements Runnable {
	private Deque<Event> deque;

	public WriterTask(Deque<Event> deque) {
		this.deque = deque;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Event event = new Event();
			event.setDate(new Date());
			event.setEvent(String.format("Message: The thread %s has generated an event", Thread.currentThread().getId()));
			deque.addFirst(event);
			System.out.println(event.getEvent());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
