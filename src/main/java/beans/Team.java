package beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Team {

	private String teamName;
	private String teamId;
	private Personnel coach;
	private Personnel owner;
	private Personnel second_coach;
	private Personnel manager;

	@Autowired
	private List<Player> players;

	public Team() {
//		System.out.println("Team created.");
	}

	public Team(String name) {
		this();
		this.teamName = name;
	}

	public String getTeamName() {
		return teamName;
	}

	public String getTeamId() {
		return teamId;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Personnel getOwner() {
		return owner;
	}

	public Personnel getCoach() {
		return coach;
	}

	public Personnel getManager() {
		return manager;
	}

	public void setCoach(Personnel coach) {
		this.coach = coach;
	}

	public void setManager(Personnel manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "{" 
				+ "teamName: " + this.teamName
				+ " , " + "players: [" + (this.players != null ? this.players.toString() : "null") + "]"
				+ " , " + "coach: " + this.coach
				+ " , " + " managere: "+ this.manager
				+ "}";
	}
}
