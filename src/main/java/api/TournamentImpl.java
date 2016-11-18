package api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import beans.Match;
import beans.Tournament;
import database.DatabaseManager;
import util.Key;

public class TournamentImpl implements ITournament {

	/**
	 * Create a tournament with unique name, if a name pre-exists it will not
	 * create another. A valid name is non-empty, not NULL, starts with alphabet
	 * with at least 6 characters long string.
	 * 
	 * @name
	 * @return Tournament object if created or pre-exist or null if name is invalid.
	 */
	@Override
	public Tournament createTournament(String name) {
		if(name == null || "".equalsIgnoreCase(name.trim()) 
				|| name.matches("^[a-zA-Z]\\S{5,}")
//				|| name.trim().length() < 6
				)
			return null;
		/* First check if a tournament exists with exact name (Case in-sensitive) */
		for (Tournament t : this.findTournament(name)) {
			if (t.getName().equalsIgnoreCase(name))
				// TODO Add log instead of sysout
				System.out.println("Found an existing tournament.");
				return t;
		}
		
		Tournament tournament = new Tournament(name.trim());
		DatabaseManager.getInstance().AddTournament(tournament);
		System.out.println("Created a new tournament.");
		return tournament;
	}

	@Override
	public List<Tournament> findTournament(String searchKey) {
		// TODO This would make a call to DB methods.
		if (searchKey == null || searchKey.trim().length() == 0)
			return new ArrayList<Tournament>();
		else
			return DatabaseManager.getInstance().findTournament(searchKey);
	}
	
	@Override
	public Tournament getTournament(Key key) {
		return DatabaseManager.getInstance().getTournament(key);
	}

	@Override
	public Set<Match> getTournamentMatches(Key key) {
		Tournament t = this.getTournament(key);
		if (t == null)
			return null;
		else
			return t.getSchedule().getMatches();

	}
}
