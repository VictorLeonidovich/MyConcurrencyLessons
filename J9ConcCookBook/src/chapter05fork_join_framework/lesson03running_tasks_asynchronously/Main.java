package chapter05fork_join_framework.lesson03running_tasks_asynchronously;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		FolderProcessor system = new FolderProcessor("C:\\Windows\\system32", "log");
		FolderProcessor apps = new FolderProcessor("C:\\Program Files\\Java", "log");
		FolderProcessor documents = new FolderProcessor("C:\\Documents And Settings\\All Users", "log");
		pool.execute(system);
		pool.execute(apps);
		pool.execute(documents);
		do {
			System.out.println("******************************************************");
			System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
			System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
			System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
			System.out.println("******************************************************");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while ((!system.isDone()) || (!apps.isDone()) || (!documents.isDone()));
		pool.shutdown();
		int printResult = 0;
		List<String> results;
		results = system.join();
		System.err.println("MAIN: system: " + system);
		if (!results.isEmpty()) {
			printResult = results.size();
		}
		System.out.printf("System: %d files found.\n", printResult);
		results = apps.join();
		if (!results.isEmpty()) {
			printResult = results.size();
		}
		System.out.printf("Apps: %d files found.\n", printResult);
		results = documents.join();
		if (!results.isEmpty()) {
			printResult = results.size();
		}
		System.out.printf("Documents: %d files found.\n", printResult);
	}

}
