
public class Flooring extends Material {
	private static double limit;
	private double widthOfFlooring;
	
	public Flooring(String name, double price, double width) {
		super(name, price);
		if (width <= 0) {
			throw new IllegalArgumentException("The width argument must be greater than 0");
		}
		limit = 0.02;
		this.widthOfFlooring = width;
	}
	
	public double getWidth() {
		return this.widthOfFlooring;
	}
	
	public int getMaterialRequirements(Surface surface) {
		if (surface == null) {
			throw new NullPointerException("The surface parameter cannot be null.");
		}
		double area = surface.getArea();
		double quotient = area / widthOfFlooring;
		quotient = quotient - limit;
		double sub = quotient;
		quotient = Math.ceil(quotient);
		if (sub == Math.floor(sub) && !Double.isInfinite(sub)
				&& limit >= 0.02) {
			quotient++;
		}
		return (int) quotient;
	}
}
