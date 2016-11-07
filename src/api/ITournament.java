package api;

import java.util.List;
import java.util.Set;

import beans.Match;
import beans.Tournament;
import util.Key;

public interface ITournament {

	/* Create a new tournament with given name */
	public Tournament createTournament(String name);
	
	/* Get all the tournaments that contains searchKey in the name */
	public List<Tournament> findTournament(String searchKey);
	
	/* Get tournament by key */
	public Tournament getTournament(Key key);
	/* Get Tournament teams, matches can be done using getter in the bean object */
	
	/* Get Matches of a tournament by tournament key */
	public Set<Match> getTournamentMatches(Key key);
	
	
}
