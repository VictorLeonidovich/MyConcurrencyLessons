package chapter08customizing_concurrency_classes.lesson06threadfactory_forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

public class MyWorkerThread extends ForkJoinWorkerThread {
	private final static ThreadLocal<Integer> TASK_COUNTER = new ThreadLocal<>();

	protected MyWorkerThread(ForkJoinPool pool) {
		super(pool);
	}

	@Override
	protected void onStart() {
		super.onStart();
		System.out.printf("MyWorkerThread %d: Initializing task counter.\n", getId());
		TASK_COUNTER.set(0);
	}

	@Override
	protected void onTermination(Throwable exception) {
		System.out.printf("MyWorkerThread %d: count: %d\n", getId(), TASK_COUNTER.get());
		super.onTermination(exception);
	}

	public void addTask() {
		TASK_COUNTER.set(TASK_COUNTER.get() + 1);
	}
}
