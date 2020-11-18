import java.util.Set;
import java.util.TreeSet;

public class PlainTextCollector implements KeywordCollector {

	@Override
	public Set<String> getKeywords(Resource res) {
		if (res == null) {
			throw new NullPointerException("The resource parameter cannot be null.");
		}
		TextFileIterator iterator = new TextFileIterator(res);
		TreeSet<String> result = new TreeSet<String>();
		while (iterator.hasNext()) {
			result.add(iterator.next());
		}
		return result;
	}

}
