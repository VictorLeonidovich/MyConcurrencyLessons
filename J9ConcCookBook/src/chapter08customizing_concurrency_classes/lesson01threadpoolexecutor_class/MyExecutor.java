package chapter08customizing_concurrency_classes.lesson01threadpoolexecutor_class;

import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyExecutor extends ThreadPoolExecutor {
	private final ConcurrentHashMap<Runnable, Date> startTimes;

	public MyExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		startTimes = new ConcurrentHashMap<>();
	}

	@Override
	public void shutdown() {
		System.out.println("MyExecutor: Going to shutdown.");
		System.out.printf("MyExecutor: Executed tasks: %d\n", getCompletedTaskCount());
		System.out.printf("MyExecutor: Running tasks: %d\n", getActiveCount());
		System.out.printf("MyExecutor: Pending tasks: %d\n", getQueue().size());
		super.shutdown();
	}

	@Override
	public List<Runnable> shutdownNow() {
		System.out.printf("MyExecutor: Going to immediately	shutdown.\n");
		System.out.printf("MyExecutor: Executed tasks: %d\n", getCompletedTaskCount());
		System.out.printf("MyExecutor: Running tasks: %d\n", getActiveCount());
		System.out.printf("MyExecutor: Pending tasks: %d\n", getQueue().size());
		return super.shutdownNow();
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		System.out.printf("MyExecutor: A task is beginning: name-%s : hashcode-%s\n", t.getName(), r.hashCode());
		startTimes.put(r, new Date());
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		Future<?> result = (Future<?>) r;
		System.out.println("********************************************");
		System.out.println("MyExecutor: A task is finishing. " + Thread.currentThread().getName());
		try {
			System.out.printf("MyExecutor: Result: %s\n", result.get());
			Date startDate = startTimes.remove(r);
			Date finishDate = new Date();
			long diff = finishDate.getTime() - startDate.getTime();
			System.out.printf("MyExecutor: Duration: %d\n", diff);
			System.out.println("********************************************");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
