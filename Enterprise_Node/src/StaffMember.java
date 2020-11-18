import java.util.Set;
import java.util.TreeSet;

public class StaffMember implements java.lang.Comparable<StaffMember>, EnterpriseNode {
	private String name;
	private String job;
	private Set<StaffMember> directSubordinates;
	
	public StaffMember(String name, String job) {
		if (name.equals(null)) {
			throw new NullPointerException("The name of a staff member cannot be a null object.");
		}
		if (job.equals(null)) {
			throw new NullPointerException("The name of the staff member's job cannot be a null object.");
		}
		if (name.equals("")) {
			throw new IllegalArgumentException("The name of a staff member cannot be blank.");
		}
		if (job.equals("")) {
			throw new IllegalArgumentException("The name of the staff member's job cannot be blank.");
		}
		this.name = name;
		this.job = job;
		directSubordinates = new TreeSet<StaffMember>();
	}
	
	public String getJob() {
		return job;
	}
	
	public boolean addDirectSubordinate(StaffMember subordinate) {
		if (subordinate.equals(null)) {
			throw new NullPointerException("The subordinate cannot be a null object.");
		}
		
		Set<StaffMember> parameterSubordinates = subordinate.getDirectSubordinates();
		if (directSubordinates.contains(subordinate)) {
			return false;
		}
		if (parameterSubordinates.contains(this)) {
			return false;
		}
		directSubordinates.add(subordinate);
		return true;
	}
	
	public boolean removeDirectSubordinate(StaffMember subordinate) {
		if (subordinate.equals(null)) {
			throw new NullPointerException("The subordinate cannot be a null object.");
		}
		if (directSubordinates.contains(subordinate)) {
			directSubordinates.remove(subordinate);
			return true;
		}
		return false;
	}
	
	public Set<StaffMember> getDirectSubordinates() {
		return directSubordinates;
	}
	
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(StaffMember o) {
		return name.compareTo(o.toString());
	}

	@Override
	public String getName() {
		return name;
	}

}
