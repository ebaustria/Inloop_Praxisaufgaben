import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class Auction {
	private boolean closed;
	private List<Item> allItems;
	private List<Person> bidders;
	
	public Auction() {
		this.closed = false;
		this.allItems = new LinkedList<Item>();
		this.bidders = new LinkedList<Person>();
	}
	
	public void addBid(Item bidItem, String nameOfBidder, long price) {
		if (this.closed) {
			throw new IllegalStateException("The auction is closed.");
		}
		if (bidItem == null) {
			throw new NullPointerException("The bid item parameter cannot be null.");
		}
		if (nameOfBidder == null) {
			throw new NullPointerException("The bidder name parameter cannot be null.");
		}
		if (nameOfBidder.equals("")) {
			throw new IllegalArgumentException("The name parameter cannot be blank.");
		}
		if (price <= 0) {
			throw new IllegalArgumentException("The price must be greater than or equal to 0.");
		}
		if (!this.allItems.contains(bidItem)) {
			throw new NoSuchElementException("The item is not registered in the auction.");
		}

		Person newPerson = new Person(nameOfBidder);
		bidItem.addBid(newPerson, price);
		bidders.add(newPerson);
	}
	
	public String closeAuction() {
		if (this.closed) {
			throw new IllegalStateException("The auction is already closed.");
		}
		
		this.closed = true;
		
		return this.generateItemListString();
	}
	
	public String generateAllBidsString(Item item) {
		if (item == null) {
			throw new NullPointerException("The item parameter cannot be null.");
		}
		
		LinkedList<Bid> allBids = (LinkedList<Bid>) item.getAllBids();
		String result = "All bids:";
		for (Bid bid : allBids) {
			result = result + "\n" + bid.toString();
		}
		
		return result;
	}
	
	public String generateItemListString() {
		String result = "";
		
		for (Item item : this.allItems) {
			result = result + this.generateItemString(item) + "\n";
		}
		
		return result;
	}
	
	public void registerItem(Item item) {
		if (item == null) {
			throw new NullPointerException("The item parameter cannot be null.");
		}
		if (this.closed) {
			throw new IllegalStateException("The auction is already closed.");
		}
		String name = item.getName();
		for (Item i : allItems) {
			if (name.equals(i.getName())) {
				throw new IllegalArgumentException("Duplicate item names are not allowed.");
			}
		}
		
		this.allItems.add(item);
	}
	
	public abstract String generateItemString(Item item);
	
	public List<Item> getAllItems() {
		return this.allItems;
	}
}
