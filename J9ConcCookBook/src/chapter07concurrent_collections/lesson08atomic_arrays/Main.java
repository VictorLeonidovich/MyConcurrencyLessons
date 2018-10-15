package chapter07concurrent_collections.lesson08atomic_arrays;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main {

	public static void main(String[] args) {
		final int THREADS = 100;
		AtomicIntegerArray vector = new AtomicIntegerArray(1000);
		Incrementer incrementer = new Incrementer(vector);
		Decrementer decrementer = new Decrementer(vector);
		Thread[] incThread = new Thread[THREADS];
		Thread[] decThread = new Thread[THREADS];
		for (int i = 0; i < THREADS; i++) {
			incThread[i] = new Thread(incrementer);
			decThread[i] = new Thread(decrementer);
			incThread[i].start();
			decThread[i].start();
		}
		for (int i = 0; i < THREADS; i++) {
			try {
				incThread[i].join();
				decThread[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int errors = 0;
		for (int i = 0; i < vector.length(); i++) {
			if (vector.get(i) != 0) {
				System.out.println("Vector[" + i + "] : " + vector.get(i));
				errors++;
			}
		}
		if (errors == 0) {
			System.out.println("No errors found");
		}
		System.out.println("Main: End of the example");

	}

}
