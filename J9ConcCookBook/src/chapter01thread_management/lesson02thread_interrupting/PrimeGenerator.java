package chapter01thread_management.lesson02thread_interrupting;

public class PrimeGenerator extends Thread {

	@Override
	public void run() {
		long number = 1L;
		while (true) {
			if (isPrime(number)) {
				System.out.printf("Number %d is Prime\n", number);
			}
			if (interrupted()) { // set attribure to false
				// if (isInterrupted()) { //doesn't set attribure to false
				System.out.println("The Prime Generator has been Interrupted");
				return;
			}
			number++;
		}

	}

	private boolean isPrime(long number) {
		if (number <= 2) {
			return true;
		}
		for (long i = 2; i < number; i++) {
			if ((number % i) == 0) {
				return false;
			}
		}
		return true;
	}
}
