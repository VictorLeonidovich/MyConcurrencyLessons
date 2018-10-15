package chapter02basic_thread_synchronization.lesson01method_synchronization.safed;

public class ParkingStats {
	private long numberCars;
	private long numberMotorcycles;
	private ParkingCash cash;
	private final Object controlCars, controlMotorsycles;

	public ParkingStats(ParkingCash cash) {
		this.numberCars = 0;
		this.numberMotorcycles = 0;
		controlCars = new Object();
		controlMotorsycles = new Object();
		this.cash = cash;
	}

	public void carComeIn() {
		synchronized (controlCars) {
			numberCars++;
		}
	}

	public void carGoOut() {
		synchronized (controlCars) {
			numberCars--;
		}
		cash.vechiclePay();
	}

	public void motoComeIn() {
		synchronized (controlMotorsycles) {
			numberMotorcycles++;
		}
	}

	public void motoGoOut() {
		synchronized (controlMotorsycles) {
			numberMotorcycles--;
		}
		cash.vechiclePay();
	}

	public long getNumberCars() {
		return numberCars;
	}

	public long getNumberMotorcycles() {
		return numberMotorcycles;
	}

}
