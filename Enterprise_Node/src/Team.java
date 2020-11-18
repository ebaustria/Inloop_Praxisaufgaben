import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Team extends AbstractEnterpriseUnit {
	private StaffMember teamLeader;

	public Team(String name, StaffMember teamLeader) {
		super(name);
		if (teamLeader.equals(null)) {
			throw new NullPointerException("The team leader cannot be a null object.");
		}
		this.teamLeader = teamLeader;
	}
	
	public StaffMember getTeamLeader() {
		return teamLeader;
	}
	
	public List<StaffMember> getTeamMembers() {
		List<StaffMember> team = new ArrayList<StaffMember>();
		Set<StaffMember> subordinates = teamLeader.getDirectSubordinates();
		StaffMemberIterator iter = new StaffMemberIterator(subordinates);
		
		while (iter.hasNext()) {
			team.add((StaffMember) iter.next());
		}
		
		team.add(teamLeader);
		
		subordinates.clear();
		subordinates.addAll(team);
		team.clear();
		team.addAll(subordinates);
		
		return team;
	}
}
