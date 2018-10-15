package chapter07concurrent_collections.lesson05threadsafe_navigable_maps;

public class Contact {
	private final String name;
	private final String phone;

	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

}
