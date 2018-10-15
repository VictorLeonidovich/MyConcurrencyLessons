package chapter06parallel_and_reactive_streams.lesson03collecting_elements_of_stream;

public class Counter {
	private String value;
	private int counter;

	public String getValue() {
		return value;
	}

	public int getCounter() {
		return counter;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public void increment() {
		counter++;
	}

}
