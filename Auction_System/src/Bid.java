
public class Bid {
	private long price;
	private Person bidder;
	
	public Bid(Person bidder, long price) {
		if (bidder == null) {
			throw new NullPointerException("The bidder cannot be a null object.");
		}
		if (price <= 0) {
			throw new IllegalArgumentException("The price must be greater than 0.");
		}
		this.bidder = bidder;
		this.price = price;
	}
	
	public Person getBidder() {
		return bidder;
	}
	
	public long getPrice() {
		return price;
	}
	
	public String toString() {
		return price + " EUR by " + bidder.getName();
	}
}
