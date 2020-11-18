import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class DesktopSearch {
	private Map<String, ResourceType> types;
	private Index index;
	
	public DesktopSearch() {
		types = new TreeMap<String, ResourceType>();
		index = new Index();
	}
	
	public void registerType(String extension, ResourceType type) {
		if (extension == null || type == null) {
			throw new NullPointerException("Neither the extension parameter nor the type parameter may be null.");
		}
		types.put(extension, type);
	}
	
	public ResourceType getType(String extension) {
		ResourceType result = null;
		for (Entry<String, ResourceType> entry : types.entrySet()) {
			if (entry.getKey().equals(extension)) {
				result = entry.getValue();
			}
		}
		return result;
	}
	
	public void unregisterType(String extension) {
		if (extension == null) {
			throw new NullPointerException("The extension parameter cannot be null.");
		}
		types.remove(extension);
	}
	
	public void registerResource(Resource res) {
		index.add(res);
	}
	
	public List<Resource> processRequest(String request) {
		List<Resource> result = index.getResources(request);
		return result;
	}
}
