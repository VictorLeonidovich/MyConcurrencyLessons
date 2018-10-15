package chapter04thread_executors.lesson01thread_executor_creation;

public class Main {

	public static void main(String[] args) {
		Server server = new Server();
		System.out.println("Main: Starting.");
		Task task;
		for (int i = 0; i < 100; i++) {
			task = new Task("Task " + i);
			server.executeTask(task);
		}
		System.out.println("Main: Shuting down the Executor.\n");
		server.endServer();
		System.out.println("Main: Sending another Task.");
		task = new Task("rejected Task");
		server.executeTask(task);
		System.out.println("Main: End.");
	}

}
