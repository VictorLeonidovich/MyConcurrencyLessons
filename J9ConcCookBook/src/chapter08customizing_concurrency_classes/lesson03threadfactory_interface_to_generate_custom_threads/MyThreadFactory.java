package chapter08customizing_concurrency_classes.lesson03threadfactory_interface_to_generate_custom_threads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory {
	private AtomicInteger counter;
	private String prefix;

	public MyThreadFactory(String prefix) {
		this.prefix = prefix;
		counter = new AtomicInteger(1);
	}

	@Override
	public Thread newThread(Runnable r) {
		MyThread myThread = new MyThread(r, prefix + "-" + counter.getAndIncrement());
		return myThread;
	}

}
