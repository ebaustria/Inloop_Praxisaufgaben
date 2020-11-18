import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PredicateIterator<T> implements java.util.Iterator<T> {
	private Iterator<T> iter;
	private Predicate<T> predicate;
	private List<T> collection;
	private List<T> predicateFulfilled;
	private int current;
	
	public PredicateIterator(Iterator<T> iter, Predicate<T> predicate) {
		this.iter = iter;
		this.predicate = predicate;
		collection = new ArrayList<T>();
		predicateFulfilled = new ArrayList<T>();
		while (iter.hasNext()) {
			collection.add(iter.next());
		}
		for (T element : collection) {
			if (predicate.test(element)) {
				predicateFulfilled.add(element);
			}
		}
		current = 0;
	}

	@Override
	public boolean hasNext() {
		if (current < predicateFulfilled.size()) {
			return true;
		}
		return false;
	}

	@Override
	public T next() {
		if (this.hasNext()) {
			int result = current;
			current++;
			return predicateFulfilled.get(result);
		} else {
			throw new NoSuchElementException("There is no next element.");
		}
	}
	
}
