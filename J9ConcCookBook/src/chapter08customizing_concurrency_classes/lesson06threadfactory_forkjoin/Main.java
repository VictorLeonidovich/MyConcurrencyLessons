package chapter08customizing_concurrency_classes.lesson06threadfactory_forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;


public class Main {

	public static void main(String[] args) {
		MyWorkingThreadFactory factory = new MyWorkingThreadFactory();
		ForkJoinPool pool = new ForkJoinPool(4, factory, null, false);
		int[] array = new int[100000];
		for (int i = 0; i < array.length; i++) {
			array[i] = 1;
		}
		MyRecursiveTask task = new MyRecursiveTask(array, 0, array.length);
		pool.execute(task);
		task.join();
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.printf("Main: Result: %d\n", task.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("Main: End of the program.");
	}

}
