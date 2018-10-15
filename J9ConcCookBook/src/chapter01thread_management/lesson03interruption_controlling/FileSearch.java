package chapter01thread_management.lesson03interruption_controlling;

import java.io.File;

public class FileSearch implements Runnable {
	private String initPath;
	private String fileName;

	public FileSearch(String initPath, String fileName) {
		this.initPath = initPath;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		File file = new File(initPath);
		if (file.isDirectory()) {

			try {
				directoryProcess(file);
			} catch (InterruptedException e) {
				System.err.printf("%s : The search has been interrupted\n", Thread.currentThread().getName());
			}

		}
	}

	private void directoryProcess(File file) throws InterruptedException {
		System.out.printf("Directory name: %s\n", file.getAbsolutePath());
		File list[] = file.listFiles();
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				if (list[i].isDirectory()) {
					directoryProcess(list[i]);
				} else {
					fileProcess(list[i]);
				}
			}
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}

	private void fileProcess(File file) throws InterruptedException {
		if (file.getName().equals(fileName)) {
			System.err.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}

}
