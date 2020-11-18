
public class Paint extends Material {
	private static double limit;
	private int numberOfCoats;
	private double squareMetersPerLiter;
	
	public Paint(String name, double price, int numberOfCoats, double squareMetersPerLiter) {
		super(name, price);
		if (numberOfCoats <= 0) {
			throw new IllegalArgumentException("The number of coats has to be positive.");
		}
		if (squareMetersPerLiter <= 0) {
			throw new IllegalArgumentException("The number of square meters per liter must be positive.");
		}
		this.numberOfCoats = numberOfCoats;
		this.squareMetersPerLiter = squareMetersPerLiter;
		limit = 0.02;
	}
	
	public int getNumberOfCoats() {
		return numberOfCoats;
	}
	
	public double getSquareMetersPerLiter() {
		return squareMetersPerLiter;
	}
	
	public int getMaterialRequirements(Surface surface) {
		if (surface == null) {
			throw new NullPointerException("The surface parameter cannot be null.");
		}
		double surfaceArea = surface.getArea();
		double liters = ((surfaceArea * numberOfCoats)/squareMetersPerLiter);
		liters = liters - limit;
		double bucketNum = liters / 0.5;
		bucketNum = Math.ceil(bucketNum);
		if (liters == Math.floor(liters) && !Double.isInfinite(liters)
				&& limit >= 0.02) {
			bucketNum++;
		}
		if (liters == Math.floor(liters) + 0.5 && !Double.isInfinite(liters)
				&& limit >= 0.02) {
			bucketNum++;
		}
		return (int) bucketNum;
	}
}
