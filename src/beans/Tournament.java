package beans;

import java.util.ArrayList;
import java.util.List;

import api.Searchable;
import util.Key;

public class Tournament implements Searchable {

	public enum TOURNAMENT_TYPE {
		BILATERAL, TRILATERAL, SERIES, KNOCKOUT, WORLD_CUP, ASHES, ASSOCIATE_NATION_WC
	}
	private int id;
	private Key tkey;
	private String name;
	private List<Personnel> committee;
	private List<Team> teams;
	private Schedule schedule;
	private static String keyPrefix = "TRMT";

	/* Get match list from Schedule instead */
	@Deprecated
	private List<Match> matches;

	public Tournament() {
		teams = new ArrayList<Team>();
		matches = new ArrayList<Match>();
		committee = new ArrayList<Personnel>();
	}

	public Tournament(String name) {
		this();
		this.name = name;
		this.generateKey();
	}

	public boolean addTeam(Team team) {
		if (team == null)
			return false;
		return teams.add(team);
	}

	@Override
	public Searchable findByKey(Key key) {
		if (this.tkey.equals(key))
			return this;
		else
			return null;
	}

	@Override
	public Key generateKey() {
		String keySuffix = this.getName().replaceAll("\\s", "").toUpperCase();
		this.tkey = new Key(keyPrefix + keySuffix);
		return this.tkey;
	}

	/**
	 * Use the Schedule class map to register matches in playgrounds.
	 * 
	 * @param match
	 * @return
	 */
	@Deprecated
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

	public int getId() {
		return id;
	}

	public Key getTkey() {
		return tkey;
	}
	
	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public String getName() {
		return name;
	}
}
