package chapter06parallel_and_reactive_streams.lesson03collecting_elements_of_stream;

import java.util.Date;

public class Person implements Comparable<Person> {

	private int id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private int salary;
	private double coefficient;

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
		int compareLastNames = this.getLastName().compareTo(otherPerson.getLastName());
		if (compareLastNames != 0) {
			return compareLastNames;
		} else {
			return this.getFirstName().compareTo(otherPerson.getFirstName());

		}
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	

}
