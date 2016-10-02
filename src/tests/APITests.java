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

		// Add Teams
		Team tigers = new Team("Tigers");
		Team umkc = new Team("UMKC");
		Team indians = new Team("Indians");
		// System.out.println(tigers);
		tournament.addTeam(tigers);
		tournament.addTeam(umkc);
		tournament.addTeam(indians);

		// Create Matches
		Squad tigerSquad = new Squad(tigers, true);
		tigerSquad.setPlayers(this.generateSquadPlayers(tigers));
		Squad umkcSquad = new Squad(umkc, false);
		umkcSquad.setPlayers(this.generateSquadPlayers(umkc));
		Match m1 = new Match("M1", tigerSquad, umkcSquad, Match.MatchType.ODI);

		//System.out.println(m1.toString());

		tournament.addMatch(m1);
		schedule.registerMatch(m1, ground1);
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
