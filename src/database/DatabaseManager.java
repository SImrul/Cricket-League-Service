package database;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import beans.Personnel;
import beans.Personnel.ROLE;
import beans.Player;
import beans.Team;
import beans.Tournament;
import util.PersonnelUtil;

public class DatabaseManager {

	private List<Player> players = new ArrayList<>();
	private List<Team> teams = new ArrayList<>();
	private List<Tournament> tournaments = new ArrayList<>();

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
}
