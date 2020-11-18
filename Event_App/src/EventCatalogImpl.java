import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EventCatalogImpl extends java.util.TreeMap<Event, Set<Time>> implements EventCatalog {

	@Override
	public boolean addCatalogEntry(Event e, Set<Time> tSet) {
		if (e == null) {
			throw new NullPointerException("The event parameter cannot be null.");
		}
		if (tSet.contains(null) || tSet == null) {
			throw new NullPointerException("The tSet parameter cannot contain null elements or be a null object.");
		}
		if (this.containsKey(e)) {
			return false;
		}
		this.put(e, tSet);
		return true;
	}

	@Override
	public boolean addTimeToEvent(Event e, Time t) {
		if (e == null || t == null) {
			throw new NullPointerException("The event and time parameters cannot be null.");
		}
		if (!this.containsKey(e)) {
			return false;
		}
		if (this.get(e).contains(t)) {
			return false;
		}
		this.get(e).add(t);
		return true;
	}

	@Override
	public Set<Event> getAllEvents() {
		return this.keySet();
	}

	@Override
	public Set<Time> getTimesOfEvent(Event e) {
		if (e == null) {
			throw new NullPointerException("The event parameter cannot be null.");
		}
		if (this.containsKey(e)) {
			return this.get(e);
		}
		return null;
	}

	@Override
	public Map<Event, Set<Time>> filterByEventCategory(EventCategory category) {
		if (category == null) {
			throw new NullPointerException("The category argument cannot be null.");
		}
		Map<Event, Set<Time>> result = new TreeMap<Event, Set<Time>>();
		for (Event e : this.keySet()) {
			if (e.getCategory().equals(category)) {
				result.put(e, this.get(e));
			}
		}
		return result;
	}

	@Override
	public Set<Time> deleteEvent(Event e) {
		if (e == null) {
			throw new NullPointerException("The event parameter cannot be null.");
		}
		if (this.containsKey(e)) {
			Set<Time> result = this.get(e);
			this.remove(e);
			return result;
		}
		return null;
	}

	@Override
	public boolean deleteTime(Event e, Time t) {
		if (e == null || t == null) {
			throw new NullPointerException("The event and time parameters cannot be null.");
		}
		if (this.containsKey(e)) {
			if (this.get(e).contains(t)) {
				this.get(e).remove(t);
				return true;
			}
		}
		return false;
	}

}
