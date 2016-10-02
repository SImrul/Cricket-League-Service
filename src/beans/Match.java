package beans;

import java.util.Date;

public class Match {

	public enum MatchType {
		ODI, TEST, TWENTY_TWENTY, PRACTICE, WORLD_CUP
	}

	private int matchId;
	private String matchName;
	private Squad homeTeam;
	private Squad awayTeam;
	private Personnel umpire1;
	private Personnel umpire2;
	private Personnel match_refree;
	private ScoreCard scoreCard;
	private Date startTime;
	private MatchType matchType;

	public Match(String matchName, Squad homeTeam, Squad awayTeam, MatchType matchType) {
		this.matchName = matchName;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.matchType = matchType;
	}

	@Override
	public String toString() {
		return "{" 
				+ "matchName: " + this.matchName
				+ " , " + "homeTeam: " + (this.homeTeam != null ? this.homeTeam.toString() : "null") 
				+ " , " + "awayTeam: " + (this.awayTeam != null ? this.awayTeam.toString() : "null")
//				+ " , " + "matchType: " + this.matchType
				+ "}";
	}
	
	public int getMatchId() {
		return matchId;
	}
	
	public String getMatchName() {
		return matchName;
	}
}
