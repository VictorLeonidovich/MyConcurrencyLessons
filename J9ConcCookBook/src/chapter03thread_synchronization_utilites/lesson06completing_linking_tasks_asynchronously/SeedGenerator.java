package chapter03thread_synchronization_utilites.lesson06completing_linking_tasks_asynchronously;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class SeedGenerator implements Runnable {
	private CompletableFuture<Integer> resultCommunicator;

	public SeedGenerator(CompletableFuture<Integer> resultCommunicator) {
		this.resultCommunicator = resultCommunicator;
	}

	@Override
	public void run() {
		System.out.println("SeedGenerator: Generating seed...");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int seed = (int) Math.rint(Math.random() * 10);
		System.out.printf("SeedGenerator: Seed generated: %d\n", seed);
		resultCommunicator.complete(seed);
	}

}
