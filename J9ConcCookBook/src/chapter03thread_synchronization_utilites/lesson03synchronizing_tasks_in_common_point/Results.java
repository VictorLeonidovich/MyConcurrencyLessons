package chapter03thread_synchronization_utilites.lesson03synchronizing_tasks_in_common_point;

public class Results {
	private final int DATA[];

	public Results(int size) {
		DATA = new int[size];
	}

	public void setData(int position, int value) {
		DATA[position] = value;
	}

	public int[] getData() {
		return DATA;
	}
}
