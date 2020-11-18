
public class EndsWith implements Predicate<String> {
	private String suffix;
	
	public EndsWith(String suffix) {
		if (suffix == null) {
			throw new IllegalArgumentException("The suffix parameter cannot be null.");
		}
		this.suffix = suffix;
	}

	@Override
	public boolean test(String value) {
		if (value == null) {
			return false;
		}
		if (suffix.equals("")) {
			return true;
		}
		if (value.equals("")) {
			return false;
		}
		int length = suffix.length();
		String subValue = value.substring(value.length() - length);
		if (subValue.equals(suffix)) {
			return true;
		}
		return false;
	}
}
