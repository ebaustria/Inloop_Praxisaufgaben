
public class Person {
	private String name;
	
	public Person(String name) {
		if (name.equals(null)) {
			throw new NullPointerException("The name cannot be a null object.");
		}
		if (name.equals("")) {
			throw new IllegalArgumentException("The name cannot be blank.");
		}
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
}
