package beans;

import java.util.Date;

public class Player {
	public enum SKILLS { BATSMAN, BOWLER, ALROUNDER, WICKETKIPPER, UNDEFINED};
	
	private String nameFirst;
	private String nameLast;
	private String nameDisplay;
	private Date DOB;
	private Player.SKILLS skill;
	private int playerId;
	
	public Player() {
		
	}
}
