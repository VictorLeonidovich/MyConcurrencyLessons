package chapter08customizing_concurrency_classes.lesson03threadfactory_interface_to_generate_custom_threads;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		MyThreadFactory myFactory = new MyThreadFactory("MyThreadFactory");
		MyTask task = new MyTask();
		Thread thread = myFactory.newThread(task);
		thread.start();
		thread.join();
		System.out.println("Main: Thread information.");
		System.out.printf("%s\n", thread);
		System.out.println("Main: End of the example.");
	}

}
