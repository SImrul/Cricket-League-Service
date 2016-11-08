package database;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import beans.Match;
import beans.Personnel;
import beans.PlayGround;
import beans.Player;
import beans.Schedule;
import beans.Team;
import beans.Tournament;
import exceptions.NameExistsException;
import exceptions.ScheduleConflictException;
import util.Key;
import util.PersonnelUtil;

public class DatabaseManager {
	
	private static DatabaseManager instance = new DatabaseManager();

	private List<Player> players = new ArrayList<>();
	private List<Team> teams = new ArrayList<>();
	private List<Tournament> tournaments = new ArrayList<>();
	private Schedule generalSchedule = new Schedule();

	private DatabaseManager() {
	}
	
	public static DatabaseManager getInstance() {
		return instance;
	}
	
	public boolean AddPlayer(Player player) {
		if (player == null)
			return false;
		return players.add(player);
	}

	public boolean AddTeam(Team team) {
		if (team == null)
			return false;
		return teams.add(team);
	}

	public boolean AddTournament(Tournament tournament) {
		if (tournament == null)
			return false;
		return tournaments.add(tournament);
	}

	/**
	 * Search the player by first/last/display name, returns the first match
	 * found or null.
	 * 
	 * @param name
	 * @return first match found or null.
	 */
	public Player getPlayerByName(String name) {
		if (name == null)
			return null;

		for (Player p : players) {
			if (StringUtils.contains(p.getNameFirst().toUpperCase(), name.toUpperCase())
					|| StringUtils.contains(p.getNameLast().toUpperCase(), name.toUpperCase())
					|| StringUtils.contains(p.getNameDisplay().toUpperCase(), name.toUpperCase())) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Get Player by ID value.
	 * 
	 * @param playerId
	 * @return return first match or null.
	 */
	public Player getPlayerById(int playerId) {
		for (Player p : players) {
			if (p.getPlayerId() == playerId)
				return p;
		}
		return null;
	}

	public Team getTeamByName(String name) {
		if (name == null)
			return null;

		for (Team t : teams) {
			if (t.getTeamName().equalsIgnoreCase(name)) {
				return t;
			}
		}
		return null;
	}

	public Team getTeamByOwner(Personnel owner) {
		return this.getTeamByPersonnel(owner, Personnel.ROLE.TEAM_OWNER);
	}

	public Team getTeamByCoach(Personnel coach) {
		return this.getTeamByPersonnel(coach, Personnel.ROLE.COACH);
	}

	public Team getTeamByManager(Personnel manager) {
		return this.getTeamByPersonnel(manager, Personnel.ROLE.MANAGER);
	}

	public Team getTeamByPersonnel(Personnel personnel, Personnel.ROLE role) {
		if (personnel == null)
			return null;
		PersonnelUtil pu = PersonnelUtil.getInstance();
		for (Team t : teams) {
			System.out.println("In loop..");
			System.out.println(pu.isSamePersonnel(t.getCoach(), personnel));
			if (pu.isSamePersonnel(t.getCoach(), personnel))
				return t;
//			else if (role == ROLE.MANAGER && pu.isSamePersonnel(t.getManager(), personnel))
//				return t;
//			else if (role == ROLE.TEAM_OWNER && pu.isSamePersonnel(t.getOwner(), personnel))
//				return t;
		}
		System.out.println("out of loop.");
		return null;
	}
	
	public Tournament getTournament(Key key) {
		for(Tournament t : this.tournaments) {
			if(t.getTkey().equals(key)) {
				return t;
			}
		}
		return null;
	}
	
	/**
	 * Currently only support one word or more that are part of the name, it doesn't
	 * search by each word if multiple words are provided.
	 * 
	 * @param searchKey
	 * @return list of {@link Tournament} or empty if not found.
	 */
	public List<Tournament> findTournament(String searchKey) {
		// TODO: find by multiple words
		List<Tournament> matched = new ArrayList<Tournament>();
		for(Tournament t: this.tournaments) {
			if(t.getName() != null && t.getName().matches("*" + searchKey + "*")) {
				matched.add(t);
			}
		}
		return matched;
	}
	
	public boolean addGeneralMatch(Match newMatch, PlayGround ground) throws ScheduleConflictException, NameExistsException{
		if(newMatch == null || ground == null) {
			return false;
		}
		// If another match is scheduled in this ground
		for (Match m : this.generalSchedule.getMatches()) {
			if (m.equals(newMatch)) {
				throw new NameExistsException(
						"Match exists with same name; names are not case sensitive and spaces are not counted while matching names.");
			}
			// if the new game is in same ground, check hours of play conflict
			PlayGround p = this.generalSchedule.getMatchGround(m);
			if (p == ground) {
				long milliseconds = 1 * 60 * 60 * 1000;
				// Does the new match starts within the existing game's hours?
				if (newMatch.getStartTime().getTime() > m.getStartTime().getTime() && newMatch.getStartTime()
						.getTime() <= (m.getStartTime().getTime() + m.getPlayHours() * milliseconds)) {
					throw new ScheduleConflictException("The new game starts within the game time of another match."
							+ "Existing match: " + m.toString());
				}
				// Does the new match game time extends after the start time of an existing game?
				else if (newMatch.getStartTime().getTime() < m.getStartTime().getTime() 
						&& m.getStartTime() .getTime() <= 
							(newMatch.getStartTime().getTime() + newMatch.getPlayHours() * milliseconds)) {
					throw new ScheduleConflictException("The new game finishes within the game time of another match."
							+ "Existing match: " + m.toString());
				}
			}
		}
		// When all validation passes, add the match in schedule
		this.generalSchedule.registerMatch(newMatch, ground);
		return true;
	}
	
	public Match getGeneralMatch(Key mKey) {
		if(mKey == null) return null;
		for(Match m : this.generalSchedule.getMatches()) {
			if(m.getKey().equals(mKey)) {
				return m;
			}
		}
		return null;
	}
	
	public boolean removeMatch(Match match) {
		return this.generalSchedule.removeMatch(match);
	}
}
