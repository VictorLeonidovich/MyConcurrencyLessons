package chapter03thread_synchronization_utilites.lesson03synchronizing_tasks_in_common_point;

import java.util.Random;

public class MatrixMock {
	private final int[][] DATA;

	public MatrixMock(int size, int length, int number) {
		int counter = 0;
		DATA = new int[size][length];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < length; j++) {
				DATA[i][j] = random.nextInt(10);
				if (DATA[i][j] == number) {
					counter++;
				}
			}
		}
		System.out.printf("Mock: There are %d ocurrences of number %d in generated data.\n", counter, number);
	}

	public int[] getRow(int row) {
		if ((row >= 0) && (row < DATA.length)) {
			return DATA[row];
		}
		return null;
	}
}
