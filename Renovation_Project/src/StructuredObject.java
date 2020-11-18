import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class StructuredObject extends RenovationObject {
	private Set<RenovationObject> parts;
	public StructuredObject() {
		super();
		parts = new HashSet<RenovationObject>();
	}
	
	public void add(RenovationObject renovationObject) {
		if (renovationObject == null) {
			throw new NullPointerException("The renovation object cannot be null.");
		}
		parts.add(renovationObject);
	}

	@Override
	public double getPrice() {
		double price = 0.0;
		for (RenovationObject surface : parts) {
			price += surface.getPrice();
		}
		return price;
	}

	@Override
	public Map<String, Integer> addMaterialRequirements(Map<String, Integer> materials) {
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
		Map<String, Integer> result1 = new TreeMap<String, Integer>();
		Map<String, Integer> result2 = new TreeMap<String, Integer>();
		for (RenovationObject surface : parts) {
			result1 = surface.addMaterialRequirements(materials);
			for (Entry<String, Integer> ent : result1.entrySet()) {
				result2.put(ent.getKey(), ent.getValue());
			}
		}
		return result2;
	}
}