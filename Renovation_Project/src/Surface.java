import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Surface extends RenovationObject {
	private double length;
	private double width;
	private Material selectedMaterial;
	
	public Surface(double length, double width) {
		if (length <= 0 || width <= 0) {
			throw new IllegalArgumentException("The length and the width of a surface must be positive.");
		}
		this.length = length;
		this.width = width;
	}
	
	public void setMaterial(Material material) {
		if (material == null) {
			throw new NullPointerException("The selected material cannot be null.");
		}
		selectedMaterial = material;
	}
	
	public double getArea() {
		return length * width;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}

	@Override
	public double getPrice() {
		return selectedMaterial.getMaterialRequirements(this)
				* selectedMaterial.getPricePerUnit();
	}

	@Override
	public Map<String, Integer> addMaterialRequirements(Map<String, Integer> materials) {
		if (this.selectedMaterial == null) {
			throw new NullPointerException("The selected material cannot be null.");
		}
		if (materials == null) {
			throw new NullPointerException("The materials parameter cannot be null.");
		}
		for (String key : materials.keySet()) {
			if (key == null) {
				throw new NullPointerException("There cannot be a null key in the materials map.");
			}
		}
		for (Integer value : materials.values()) {
			if (value == null) {
				throw new NullPointerException("There cannot be a null value in the materials map.");
			}
		}
		Map<String, Integer> materials2 = new TreeMap<String, Integer>();
		if (materials.size() == 0) {
			int units = this.selectedMaterial.getMaterialRequirements(this);
			materials2.put(this.selectedMaterial.getName(), units);
			return materials2;
		}
		for (Entry<String, Integer> material : materials.entrySet()) {
			if (this.selectedMaterial.getName().equals(material.getKey())) {
				int units = this.selectedMaterial.getMaterialRequirements(this);
				units = units + material.getValue();
				materials2.put(material.getKey(), units);
			} else {
				int units = this.selectedMaterial.getMaterialRequirements(this);
				materials2.put(this.selectedMaterial.getName(), units);
			}
		}
		return materials2;
	}
}
