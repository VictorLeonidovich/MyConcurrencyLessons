package chapter08customizing_concurrency_classes.lesson04threadfactory_in_executor;

import java.util.Date;

public class MyThread extends Thread {
	private final Date creationDate;
	private Date startDate;
	private Date finishDate;

	public MyThread(Runnable target, String name) {
		super(target, name);
		creationDate = new Date();
	}

	public void setStartDate() {
		this.startDate = new Date();
	}

	public void setFinishDate() {
		this.finishDate = new Date();
	}

	@Override
	public void run() {
		setStartDate();
		super.run();
		setFinishDate();
		System.out.println("Main: Thread information.");
		System.out.printf("%s\n", Thread.currentThread().toString());
	}

	public synchronized long getExecutionTime() {
		return finishDate.getTime() - startDate.getTime();
	}

	@Override
	public synchronized String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(getName());
		buffer.append(": ");
		buffer.append(" Creation Date: ");
		buffer.append(creationDate);
		buffer.append(" : Running time: ");
		buffer.append(getExecutionTime());
		buffer.append(" Milliseconds.");
		return buffer.toString();
	}

}
