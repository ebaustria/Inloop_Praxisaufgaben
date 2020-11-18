
public abstract class Material {
	private String name;
	private double price;
	
	public Material(String name, double price) {
		if (name == null) {
			throw new NullPointerException("The name parameter cannot be null.");
		}
		if (name == "") {
			throw new IllegalArgumentException("The material name cannot be blank.");
		}
		if (price < 0) {
			throw new IllegalArgumentException("The material price argument has to be positive.");
		}
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPricePerUnit() {
		return price;
	}
	
	public abstract int getMaterialRequirements(Surface surface);
	
	public double getPriceOfASurface(Surface surface) {
		if (surface == null) {
			throw new NullPointerException("The surface parameter cannot be null.");
		}
		return surface.getLength() * price;
	}
}
