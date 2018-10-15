package chapter02basic_thread_synchronization.lesson01method_synchronization.non_safed;

public class ParkingStats {
	private long numberCars;
	private long numberMotorcycles;
	private ParkingCash cash;

	public ParkingStats(ParkingCash cash) {
		this.numberCars = 0;
		this.numberMotorcycles = 0;
		this.cash = cash;
	}

	public void carComeIn() {
		numberCars++;
	}

	public void carGoOut() {
		numberCars--;
		cash.vechiclePay();
	}

	public void motoComeIn() {
		numberMotorcycles++;
	}

	public void motoGoOut() {
		numberMotorcycles--;
		cash.vechiclePay();
	}

	public long getNumberCars() {
		return numberCars;
	}

	public long getNumberMotorcycles() {
		return numberMotorcycles;
	}
	
}
