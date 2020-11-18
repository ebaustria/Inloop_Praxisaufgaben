
public class Resource {
	private String name;
	private String path;
	private ResourceType rt;
	
	public Resource(String name, String path, ResourceType rt) {
		if (name == null) {
			throw new NullPointerException("The name parameter cannot be null.");
		}
		if (path == null) {
			throw new NullPointerException("The path parameter cannot be null.");
		}
		if (rt == null) {
			throw new NullPointerException("The rt parameter cannot be null.");
		}
		if (name == "") {
			throw new IllegalArgumentException("The name parameter cannot be blank.");
		}
		if (path == "") {
			throw new IllegalArgumentException("The path parameter cannot be blank.");
		}
		this.name = name;
		this.path = path;
		this.rt = rt;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPath() {
		return path;
	}
	
	public ResourceType getType() {
		return rt;
	}
}
