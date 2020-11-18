import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Index {
	private Map<String, List<Resource>> index;
	
	public Index() {
		index = new TreeMap<String, List<Resource>>();
	}
	
	public void add(Resource res) {
		if (res == null) {
			throw new NullPointerException("The resource parameter cannot be null.");
		}
		ResourceType rt = res.getType();
		KeywordCollector kwc = rt.getCollector();
		Set<String> keywords = kwc.getKeywords(res);
		for (String kword : keywords) {
			List<Resource> doUpdate = getResources(kword);
			doUpdate.add(res);
			index.put(kword, doUpdate);
		}
	}
	
	public List<Resource> getResources(String keyword) {
		if (keyword == null) {
			throw new NullPointerException("The keyword parameter cannot be null.");
		}
		ArrayList<Resource> empty = new ArrayList<Resource>();
		return index.getOrDefault(keyword, empty);
	}
}
