import java.util.HashSet;
import java.util.Set;

public class DefaultCollector implements KeywordCollector {

	@Override
	public Set<String> getKeywords(Resource res) {
		if (res == null) {
			throw new NullPointerException("The resource parameter cannot be null.");
		}
		String name = res.getName();
		Set<String> keywords = new HashSet<String>();
		keywords.add(name);
		return keywords;
	}

}
