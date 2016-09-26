package beans;

import java.util.Date;

public class Match {

	public enum MatchType { ODI, TEST, TWENTY_TWENTY, PRACTICE, WORLD_CUP}
	
	private int matchId;
	private String matchName;
	private Team homeTeam;
	private Team awayTeam;
	private ScoreCard scoreCard;
	private Date startTime;
	private MatchType matchType;
	
}
