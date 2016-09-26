package beans;

import java.util.Date;

public class Player {
	public enum SKILLS {
		BATSMAN, BOWLER, ALROUNDER, WICKETKIPPER, UNDEFINED
	};

	private String nameFirst;
	private String nameLast;
	private String nameDisplay;
	private Date DOB;
	private Player.SKILLS skill;
	private int playerId;
	private Team memberOf;

	public Player() {
	}

	public int getPlayerId() {
		return playerId;
	}

	public String getNameDisplay() {
		return nameDisplay;
	}

	public Player.SKILLS getSkill() {
		return skill;
	}

	public Team getMemberOf() {
		return memberOf;
	}

	public String getNameFirst() {
		return nameFirst;
	}

	public String getNameLast() {
		return nameLast;
	}

	@Override
	public String toString() {
		return "{Player: {nameFirst: " + this.nameFirst + ", nameLast: " + this.nameLast + ", nameDisplay: "
				+ this.nameDisplay + ", Date of Birth: " + this.DOB
				// + ", Skill: " + this.getSkillDisplay()
				+ "}";
	}

	public String getSkillDisplay() {
		if (this != null) {
			switch (this.skill) {
			case BATSMAN:
				return "Batsman";
			case BOWLER:
				return "Bowler";
			default:
				return "Undefined";
			}
		} else
			return "Undefined";
	}

}
