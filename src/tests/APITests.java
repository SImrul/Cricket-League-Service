package tests;

import java.util.HashSet;
import java.util.Set;

import beans.Match;
import beans.PlayGround;
import beans.Player;
import beans.Schedule;
import beans.Squad;
import beans.Team;
import beans.Tournament;

public class APITests {

	public void generateTournament() {
		// Use Beans in next phase of development
		Tournament tournament = new Tournament("KC Cricket League");
		Schedule schedule = new Schedule();
		PlayGround ground1 = new PlayGround("Olathe");
		PlayGround ground2 = new PlayGround("Pflumn");

		// Add Teams
		Team tigers = new Team("Tigers");
		Team umkc = new Team("UMKC");
		Team indians = new Team("Indians");
		// System.out.println(tigers);
		tournament.addTeam(tigers);
		tournament.addTeam(umkc);
		tournament.addTeam(indians);

		// Create Squads
		Squad tigerSquad = new Squad(tigers, true);
		tigerSquad.setPlayers(this.generateSquadPlayers(tigers));
		Squad umkcSquad = new Squad(umkc, false);
		umkcSquad.setPlayers(this.generateSquadPlayers(umkc));
		Squad indianSquad = new Squad(indians, false);
		indianSquad.setPlayers(this.generateSquadPlayers(indians));
		
		// Create Matches
		Match m1 = new Match("M1", tigerSquad, umkcSquad, Match.MatchType.ODI);
		Match m2 = new Match("M2", tigerSquad, indianSquad, Match.MatchType.ODI);
		//System.out.println(m1.toString());

		// Schedule tournament
//		tournament.addMatch(m1);
		schedule.registerMatch(m1, ground1);
//		tournament.addMatch(m2);
		schedule.registerMatch(m2, ground2);
		System.out.println(schedule);
		

	}

	private Set<Player> generateSquadPlayers(Team team) {
		Set<Player> players = new HashSet<>(11);
		for (int i = 1; i <= 11; i++) {
			Player p = new Player(team.getTeamName(), ("P" + i), Player.SKILLS.BATSMAN, team);
			players.add(p);
		}
		return players;
	}

	public static void main(String[] args) {
		APITests apis = new APITests();
		apis.generateTournament();
	}
}
