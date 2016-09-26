package database;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import beans.Player;
import beans.Team;
import beans.Tournament;

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
}
