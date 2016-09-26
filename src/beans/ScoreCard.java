package beans;

public class ScoreCard {

	public enum WinType { BY_WICKET, BY_RUNS }
	
	private Team winner;
	private Team loser; // Need to find a better name!
	private WinType winType;
	private int winMargin;
	private Player manOfTheMatch;
}
