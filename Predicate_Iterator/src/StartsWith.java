
public class StartsWith implements Predicate<String> {
	private String prefix;
	
	public StartsWith(String prefix) {
		if (prefix == null) {
			throw new IllegalArgumentException("The prefix parameter cannot be null.");
		}
		this.prefix = prefix;
	}

	@Override
	public boolean test(String value) {
		String subValue = null;
		if (value == null) {
			return false;
		}
		if (prefix.equals("")) {
			return true;
		}
		if (value.equals("")) {
			return false;
		}
		int length = prefix.length();
		if (length <= value.length()) {
			subValue = value.substring(0, length);
		} else {
			return false;
		}
		if (subValue.equals(prefix)) {
			return true;
		}
		return false;
	}
}
