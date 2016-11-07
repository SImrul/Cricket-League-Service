package beans;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Schedule {

	/* Instead of using matches as separate entity we would utilize the matchVenue map */
	@Deprecated
	private List<Match> matches;
	// Match - Playground Mapping
	private HashMap<Match, PlayGround> matchVenues;

	public Schedule() {
		this.matchVenues = new HashMap<Match, PlayGround>();
	}

	// TODO: Need to find a suitable data structure, if it's a map then find a better KEY schema.
	public void registerMatch(Match match, PlayGround playGround) {
		// null return means there was no value assigned to the key previously.
		this.matchVenues.put(match, playGround);
	}
	
	public PlayGround getMatchGround(Match m) {
		if(m == null) return null;
		return this.matchVenues.get(m);
	}
	
	public Set<Match> getMatches() {
		return matchVenues.keySet();
	}
	
	public Collection<PlayGround> getPlayGrounds() {
		return this.matchVenues.values();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("schedules: [");
		for(Match m : matchVenues.keySet()) {
			sb.append("{");
			sb.append("Match: " + m.toString());
			sb.append(" , ");
			sb.append("Ground: " + this.matchVenues.get(m));
			sb.append("}");
		}
		sb.append("]");
		return "{" + sb.toString() + "}";
	}
}
