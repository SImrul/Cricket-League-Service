package beans;

public class ScoreCard {

	public enum WinType { BY_WICKET, BY_RUNS }
	
	private Squad winner;
	private Squad loser; // Need to find a better name!
	private WinType winType;
	private int winMargin;
	private Player manOfTheMatch;
}
