package beans;

import java.util.HashMap;
import java.util.List;

public class Schedule {

	private List<Match> matches;
	// Match - Playground Mapping
	private HashMap<Match, PlayGround> matchVenues;

	public Schedule() {
		this.matchVenues = new HashMap<Match, PlayGround>();
	}

	// TODO: Need to find a suitable data structure, if it's a map then find a better KEY schema.
	public void registerMatch(Match match, PlayGround playGround) {
		this.matchVenues.put(match, playGround);
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
