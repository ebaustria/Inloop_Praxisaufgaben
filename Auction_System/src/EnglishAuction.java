
public class EnglishAuction extends Auction {

	@Override
	public String generateItemString(Item item) {
		if (item == null) {
			throw new NullPointerException("The item parameter cannot be null.");
		}
		if (item.getAllBids().size() == 0) {
			return item.toString() + "\n" + "No bids placed";
		}
		return item.toString() + "\n" + "Highest bid: " + item.getHighestBid().toString();
	}

}
