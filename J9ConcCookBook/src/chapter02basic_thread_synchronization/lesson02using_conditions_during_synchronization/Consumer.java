package chapter02basic_thread_synchronization.lesson02using_conditions_during_synchronization;

public class Consumer implements Runnable {
	private EventStorage storage;

	public Consumer(EventStorage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			storage.get();
		}
	}

}
