package beans;

import java.util.Set;

public class Squad {

	private Team team; // associated team
	private Set<Player> players; // the playing 11 for that match
	private boolean isHomeTeam;
	private int player_bench_limit; // maximum allowable for bench

	public Squad(Team team, boolean isHomeTeam) {
		super();
		this.team = team;
		this.isHomeTeam = isHomeTeam;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	
	@Override
	public String toString() {
		return "{ "
				+ "team: " + (this.team != null ? this.team.toString() : "null")
				+ " , " + "players: "  + (this.players != null ? this.players.toString() : "null")
				+ " , " + "isHomeTeam :" + this.isHomeTeam
				+ "}";
	}
}
