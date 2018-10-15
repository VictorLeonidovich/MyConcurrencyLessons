package chapter06parallel_and_reactive_streams.lesson06transforming_elements_of_stream;

import java.util.Comparator;
import java.util.Date;

public class Person implements Comparable<Person> {

	private int id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private int salary;
	private double coefficient;
	private static Comparator<Person> comparator = Comparator.comparing(Person::getLastName)
			.thenComparing(Person::getFirstName);

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public int getSalary() {
		return salary;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	@Override
	public int compareTo(Person otherPerson) {
		return comparator.compare(this, otherPerson);
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	@Override
	public int hashCode() {
		String sequence = this.getLastName() + this.getFirstName();
		return sequence.hashCode();
	}

	@Override
	public boolean equals(Object object) {
		return this.compareTo((Person) object) == 0;
	}

}
