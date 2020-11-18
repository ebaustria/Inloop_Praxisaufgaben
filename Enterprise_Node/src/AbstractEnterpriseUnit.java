
public abstract class AbstractEnterpriseUnit implements EnterpriseNode {
	private String name;
	
	public AbstractEnterpriseUnit(String name) {
		if (name.equals(null)) {
			throw new NullPointerException("The name of an enterprise cannot be null.");
		}
		if (name.equals("")) {
			throw new IllegalArgumentException("The name of an enterprise cannot be blank");
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
