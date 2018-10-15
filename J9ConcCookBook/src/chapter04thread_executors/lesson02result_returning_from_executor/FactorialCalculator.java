package chapter04thread_executors.lesson02result_returning_from_executor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer> {
	private final Integer number;

	public FactorialCalculator(Integer number) {
		this.number = number;
	}

	@Override
	public Integer call() throws Exception {
		int result = 1;
		if ((number == 0) || (number == 1)) {
			result = 1;
		} else {
			for (int i = 2; i < number; i++) {
				result *= i;
				try {
					TimeUnit.MILLISECONDS.sleep(20);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);
		return result;
	}

}
