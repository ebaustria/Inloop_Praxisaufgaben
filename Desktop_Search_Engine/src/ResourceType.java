
public class ResourceType {
	private String description;
	private KeywordCollector collector;
	
	public ResourceType(String desc, KeywordCollector collector) {
		if (desc == null) {
			throw new NullPointerException("The description parameter cannot be null.");
		}
		if (collector == null) {
			throw new NullPointerException("The keyword collector parameter cannot be null.");
		}
		if (desc == "") {
			throw new IllegalArgumentException("The description parameter cannot be blank.");
		}
		this.description = desc;
		this.collector = collector;
	}
	
	public String getDescription() {
		return description;
	}
	
	public KeywordCollector getCollector() {
		return collector;
	}
}
