package chapter03thread_synchronization_utilites.lesson06completing_linking_tasks_asynchronously;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

	public static void main(String[] args) {
		System.out.println("main: Start");
		CompletableFuture<Integer> seedFuture = new CompletableFuture<>();
		Thread seedThread = new Thread(new SeedGenerator(seedFuture));
		seedThread.start();
		System.out.println("Main: Getting the seed");
		int seed = 0;
		try {
			seed = seedFuture.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: The seed is: %d\n", seed);
		System.out.println("Main: Launching the list of numbers generator");
		NumberListGenerator task = new NumberListGenerator(seed);
		CompletableFuture<List<Long>> startFuture = CompletableFuture.supplyAsync(task);
		System.out.println("Main: Launching step 1");
		CompletableFuture<Long> step1Future = startFuture.thenApplyAsync(list -> {
			System.out.printf("%s: Step 1: Start\n", Thread.currentThread().getName());
			long selected = 0;
			long selectedDistance = Long.MAX_VALUE;
			long distance;
			for (Long number : list) {
				distance = Math.abs(number - 1000);
				if (distance < selectedDistance) {
					selected = number;
					selectedDistance = distance;
				}
			}
			System.out.printf("%s: Step 1: Result - %d\n", Thread.currentThread().getName(), selected);
			return selected;
		});

		System.out.println("Main: Launching step 2");
		CompletableFuture<Long> step2Future = startFuture
				.thenApplyAsync(list -> list.stream().max(Long::compare).get());

		CompletableFuture<Void> write2Future = step2Future.thenAccept(selected -> {
			System.out.printf("%s: Step 2: Result - %d\n", Thread.currentThread().getName(), selected);
		});

		System.out.println("Main: Launching step 3");
		NumberSelector numberSelector = new NumberSelector();
		CompletableFuture<Long> step3Future = startFuture.thenApplyAsync(numberSelector);

		System.out.println("Main: Waiting for the end of the three steps");
		CompletableFuture<Void> waitFuture = CompletableFuture.allOf(step1Future, write2Future, step3Future);
		CompletableFuture<Void> finalFuture = waitFuture.thenAcceptAsync((param) -> {
			System.out.println("Main: The CompletableFuture example has been completed.");
		});
		finalFuture.join();
	}

}
