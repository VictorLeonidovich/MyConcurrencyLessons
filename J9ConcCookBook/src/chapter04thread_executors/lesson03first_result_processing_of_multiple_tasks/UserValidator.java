package chapter04thread_executors.lesson03first_result_processing_of_multiple_tasks;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserValidator {
	private final String name;

	public UserValidator(String name) {
		this.name = name;
	}

	public boolean validate(String name, String password) {
		Random random = new Random();
		try {
			long duration = (long) (Math.random() * 5);
			System.out.printf("Validator %s: Validating a user during %d seconds\n", this.name, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			return false;
		}
		return random.nextBoolean();
	}

	public String getName() {
		return name;
	}
	
}
