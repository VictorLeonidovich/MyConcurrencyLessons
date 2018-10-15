package chapter06parallel_and_reactive_streams.lesson04applying_action_to_every_element_of_stream;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		List<Person> persons = PersonGenerator.generatePersonList(10);
		persons.parallelStream().forEach(p -> {
			System.out.printf("%s, %s\n", p.getLastName(), p.getFirstName());
		});
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		List<Double> doubles = DoubleGenerator.generateDoubleList(10, 100);
		System.out.println("Parallel forEachOrdered() with numbers");
		doubles.parallelStream().sorted().forEachOrdered(n -> {
			System.out.println(n);
		});
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Parallel forEach() after sorted() with numbers");
		doubles.parallelStream().sorted().forEach(n -> {
			System.out.println(n);
		});
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		persons.parallelStream().sorted().forEachOrdered(p -> {
			System.out.println(p.getLastName() + ", " + p.getFirstName());
		});
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		doubles.parallelStream().peek(d -> System.out.printf("Step 1: Number: %f\n", d))
				.peek(d -> System.out.printf("Step 2: Number: %f\n", d))
				.forEach(d -> System.out.printf("Final Step: Number: %f\n", d));
	}

}
