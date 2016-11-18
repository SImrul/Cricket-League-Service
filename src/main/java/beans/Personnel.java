package beans;

import java.util.Date;

public class Personnel {

	public enum ROLE {
		COACH, SECOND_COACH, PHYSICIAN, UMPIRE, MATCH_REFREE, MANAGER, TEAM_OWNER
	};

	private String firstName;
	private String lastName;
	private String displayName;
	private ROLE role;
	private Date dob;

	public Personnel() {
	}

	public Personnel(String firstName, String lastName, String displayName, ROLE role, Date dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.displayName = displayName;
		this.role = role;
		this.dob = dob;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public ROLE getRole() {
		return role;
	}

}
