import java.util.ArrayList;
import java.util.List;

public abstract class AbstractUnit extends AbstractEnterpriseUnit {
	private List<AbstractEnterpriseUnit> childNodes;

	public AbstractUnit(String name) {
		super(name);
		childNodes = new ArrayList<AbstractEnterpriseUnit>();
	}
	
	public boolean add(AbstractEnterpriseUnit childNode) {
		if (childNode.equals(null)) {
			throw new NullPointerException("The child node parameter cannot be null.");
		}
		if (childNodes.contains(childNode)) {
			return false;
		}
		if (this instanceof Holding && !(childNode instanceof Company)) {
			throw new IllegalArgumentException("Holdings can only consist of companies.");
		}
		if (this instanceof Company && !(childNode instanceof Division)) {
			throw new IllegalArgumentException("Companies can only consist of divisions.");
		}
		if (this instanceof Division && !(childNode instanceof Team)) {
			throw new IllegalArgumentException("Divisions can only consist of teams.");
		}
		childNodes.add(childNode);
		return true;
	}
	
	public boolean remove(AbstractEnterpriseUnit childNode) {
		if (childNode.equals(null)) {
			throw new NullPointerException("The child node parameter cannot be null.");
		}
		if (childNodes.contains(childNode)) {
			childNodes.remove(childNode);
			return true;
		}
		return false;
	}
	
	public List<AbstractEnterpriseUnit> getChildNodes() {
		return childNodes;
	}
}
