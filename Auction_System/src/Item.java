import java.util.LinkedList;
import java.util.List;

public class Item {
	private String name;
	private String description;
	private long minPrice;
	private List<Bid> allBids;
	private Bid highestBid;
	
	public Item(String name, String description, long minPrice) {
		if (name == null) {
			throw new NullPointerException("The name parameter cannot be null.");
		}
		if (description == null) {
			throw new NullPointerException("The description parameter cannot be null.");
		}
		if (name.equals("")) {
			throw new IllegalArgumentException("The name parameter cannot be blank.");
		}
		if (description.equals("")) {
			throw new IllegalArgumentException("The description parameter cannot be blank.");
		}
		if (minPrice <= 0) {
			throw new IllegalArgumentException("The minimum price must be greater than 0.");
		}
		this.name = name;
		this.description = description;
		this.minPrice = minPrice;
		allBids = new LinkedList<Bid>();
	}
	
	public void addBid(Person bidder, long price) {
		if (bidder == null) {
			throw new NullPointerException("The bidder parameter cannot be null.");
		}
		if (price <= 0) {
			throw new IllegalArgumentException("The price must be greater than 0.");
		}
		if (price < minPrice) {
			return;
		}
		if (allBids.size() == 0) {
			Bid newBid = new Bid(bidder, price);
			allBids.add(newBid);
			highestBid = newBid;
			return;
		}
		if (price > highestBid.getPrice()) {
			Bid newBid = new Bid(bidder, price);
			allBids.add(newBid);
			highestBid = newBid;
			return;
		}
	}
	
	public List<Bid> getAllBids() {
		return allBids;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Bid getHighestBid() {
		return highestBid;
	}
	
	public String toString() {
		return name + ": " + description + " (minimum bidding price: " + minPrice + " EUR)";
	}
	
	public String getName() {
		return name;
	}
}
