package chapter05fork_join_framework.lesson05cancelling_a_task;

import java.util.Random;

public class ArrayGenerator {
	public int[] generateArray(int size) {
		int[] array = new int[size];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10);
		}
		return array;
	}
}
