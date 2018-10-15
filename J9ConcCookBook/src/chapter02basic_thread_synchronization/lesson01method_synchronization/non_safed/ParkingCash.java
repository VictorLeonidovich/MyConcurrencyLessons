package chapter02basic_thread_synchronization.lesson01method_synchronization.non_safed;

public class ParkingCash {
	private static final int cost = 2;
	private long cash;

	public ParkingCash() {
		cash = 0;
	}

	public void vechiclePay() {
		cash += cost;
	}

	public void close() {
		System.out.println("Closing accounting");
		long totalAmount;
		totalAmount = cash;
		cash = 0;
		System.out.printf("The total amount is: %d", totalAmount);
	}
}
