package chapter08customizing_concurrency_classes.lesson06threadfactory_forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class MyRecursiveTask extends RecursiveTask<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] array;
	private int start, end;

	public MyRecursiveTask(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		Integer ret;
		MyWorkerThread thread = (MyWorkerThread) Thread.currentThread();
		thread.addTask();
		if (start - end > 100) {
			int mid = (start + end) / 2;
			MyRecursiveTask task1 = new MyRecursiveTask(array, start, mid);
			MyRecursiveTask task2 = new MyRecursiveTask(array, mid, end);
			invokeAll(task1, task2);
			ret = addResults(task1, task2);
		} else {
			int add = 0;
			for (int i = start; i < end; i++) {
				add += array[i];
			}
			ret = add;
		}
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ret;
	}

	private Integer addResults(MyRecursiveTask task1, MyRecursiveTask task2) {
		int value;
		try {
			value = task1.get().intValue() + task2.get().intValue();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			value = 0;
		}
		return value;
	}

}
