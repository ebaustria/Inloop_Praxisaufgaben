
public class Event implements java.lang.Comparable<Event> {
	
	private String title;
	private EventCategory category;
	
	public Event(String title, EventCategory category) {
		if (title == null) {
			throw new NullPointerException("The title parameter cannot be null.");
		}
		if (category == null) {
			throw new NullPointerException("The category parameter cannot be null.");
		}
		if (title.equals("")) {
			throw new IllegalArgumentException("The title parameter cannot be blank.");
		}
		this.title = title;
		this.category = category;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public EventCategory getCategory() {
		return this.category;
	}

	@Override
	public int compareTo(Event o) {
		if (o == null) {
			throw new NullPointerException("The event parameter cannot be null.");
		}
		if (this.title.equals(o.getTitle())) {
			return this.category.compareTo(o.getCategory());
		}
		return this.title.compareTo(o.getTitle());
	}

}
