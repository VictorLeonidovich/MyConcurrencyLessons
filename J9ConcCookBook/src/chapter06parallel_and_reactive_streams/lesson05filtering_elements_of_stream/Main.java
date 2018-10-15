package chapter06parallel_and_reactive_streams.lesson05filtering_elements_of_stream;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("START:--------------------------------");
		List<Person> persons = PersonGenerator.generatePersonList(10);
		persons.parallelStream().forEach(p -> {
			System.out.println(p.getLastName() + ", " + p.getFirstName());
		});
		System.out.println("distinct--------------------------------");
		persons.parallelStream().distinct().forEach(p -> {
			System.out.println(p.getLastName() + ", " + p.getFirstName());
		});
		System.out.println("distinct--------------------------------");
		Integer[] numbers = { 1, 3, 2, 1, 2, 2, 1, 3, 3, 1, 1, 3, 2, 1 };
		Arrays.asList(numbers).parallelStream().mapToInt(n -> n).distinct().forEach(n -> {
			System.out.printf("Number: %d\n", n);
		});
		System.out.println("salary < 30000--------------------------------");
		persons.parallelStream().filter(p -> p.getSalary() < 30000).forEach(p -> {
			System.out.println(p.getLastName() + ", " + p.getFirstName());
		});
		System.out.println("n < 2--------------------------------");
		Arrays.asList(numbers).parallelStream().mapToInt(n -> n).filter(n -> n < 2).forEach(n -> {
			System.out.printf("Number: %d\n", n);
		});
		System.out.println("limit--------------------------------");
		persons.parallelStream().mapToDouble(p -> p.getSalary()).sorted().limit(5).forEach(s -> {
			System.out.printf("Limit: %f\n", s);
		});
		System.out.println("skip--------------------------------");
		persons.parallelStream().mapToDouble(p -> p.getSalary()).sorted().skip(5).forEach(s -> {
			System.out.printf("Skip: %f\n", s);
		});
	}

}
