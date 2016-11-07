package beans;

import java.util.Date;

import api.Searchable;
import util.Key;

public class Match implements Searchable{

	public enum MatchType {
		ODI, TEST, TWENTY_TWENTY, PRACTICE
	}
	public static int ODI_HOURS = 6;
	public static int TEST_HOURS = 8;
	public static int TWENTY_HOURS = 3;
	public static int PRACTICE_HOURS = 12;
	
	private static String keyPrefix = "MATCH";
	
	private int matchId;
	private String matchName;
	private Key mKey;
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
		this.generateKey();
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
	
	@Override
	public synchronized Key generateKey() {
		String keySuffix = this.getMatchName().replaceAll("\\s", "").toUpperCase() + System.currentTimeMillis();
		this.mKey = new Key(keyPrefix + keySuffix);
		return this.mKey;
	}
	
	@Override
	public Searchable findByKey(Key key) {
		if (this.mKey.equals(key))
			return this;
		else
			return null;
	}
	
	public Key getKey() {
		return mKey;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public int getPlayHours() {
		switch (this.matchType) {
		case ODI:
			return ODI_HOURS;
		case TEST:
			return TEST_HOURS;
		case TWENTY_TWENTY:
			return TWENTY_HOURS;
		default:
			return 0;
		}
	}
	
	@Override
	public int hashCode() {
		return this.mKey.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Match)) {
			return false;
		}
		Match m = (Match) obj;
		return this.mKey.equals(m.getKey());
	}
}
