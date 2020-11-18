import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class StaffMemberIterator implements EnterpriseNodeIterator {
	private Set<StaffMember> allMembers;
	private List<StaffMember> all;
	int current;
	
	public StaffMemberIterator(Set<StaffMember> directSubordinates) {
		if (directSubordinates.equals(null)) {
			throw new NullPointerException("The set of subordinates cannot be a null object.");
		}
		for (StaffMember sm : directSubordinates) {
			if (sm.equals(null)) {
				throw new NullPointerException("The set of subordinates cannot contain a null object.");
			}
		}
		
		allMembers = new TreeSet<StaffMember>();
		
		for (StaffMember sm : directSubordinates) {
			findSubordinatesRecursively(sm);
		}
		
		current = 0;
		all = new ArrayList<StaffMember>();
		all.addAll(allMembers);
	}
	
	private void findSubordinatesRecursively(StaffMember m) {
		allMembers.add(m);
		Set<StaffMember> subordinates = m.getDirectSubordinates();
		for (StaffMember s : subordinates) {
			findSubordinatesRecursively(s);
		}
	}

	@Override
	public boolean hasNext() {
		if (current < all.size()) {
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		if (this.hasNext()) {
			StaffMember result = all.get(current);
			current++;
			return result;
		}
		throw new NoSuchElementException("There is no next element.");
	}

}
