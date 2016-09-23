package beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Team {

	private String teamName;
	private String teamId;
	private Personnel coach;
	private Personnel owner;
	private Personnel second_coach;
	private Personnel manager;
	
	@Autowired
	private List<Player> players;
	private List<Player> squad; // the 11 playing members in a game
	
	public Team() {
		System.out.println("Team created.");
	}
}
