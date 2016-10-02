package beans;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

	private String name;
	private List<Personnel> committee;
	private List<Team> teams;
	private List<Match> matches;

	public Tournament() {
		teams = new ArrayList<Team>();
		matches = new ArrayList<Match>();
		committee = new ArrayList<Personnel>();
	}

	public Tournament(String name) {
		this();
		this.name = name;
	}

	public boolean addTeam(Team team) {
		if (team == null)
			return false;
		return teams.add(team);
	}

	public boolean addMatch(Match match) {
		if (match == null)
			return false;
		return matches.add(match);
	}

	public boolean addCommmitteMember(Personnel personnel) {
		if (personnel == null)
			return false;
		return committee.add(personnel);
	}
	
}
