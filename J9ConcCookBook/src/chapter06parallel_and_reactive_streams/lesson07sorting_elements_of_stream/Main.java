package chapter06parallel_and_reactive_streams.lesson07sorting_elements_of_stream;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		System.out.println("-------------Array sorting---------------");
		int[] numbers = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Arrays.stream(numbers).parallel().sorted().forEachOrdered(n -> {
			System.out.println(n);
		});
		System.out.println("-------------Persons sorting---------------");
		List<Person> persons = PersonGenerator.generatePersonList(10);
		persons.parallelStream().sorted().forEachOrdered(p -> {
			System.out.println(p.getLastName() + ", " + p.getFirstName());
		});
		System.out.println("-------------unordered() + limit---------------");
		TreeSet<Person> personSet = new TreeSet<>(persons);
		for (int i = 0; i < persons.size(); i++) {
			System.out.println("-------------" + i + "---------------");
			Person person = personSet.stream().parallel().limit(1).collect(Collectors.toList()).get(0);
			System.out.println("usual:       " + person.getFirstName() + ", " + person.getLastName());
			person = personSet.stream().unordered().parallel().limit(1).collect(Collectors.toList()).get(0);
			System.out.println("unordered(): " + person.getFirstName() + ", " + person.getLastName());

		}
	}

}
