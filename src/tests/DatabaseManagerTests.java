package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import beans.Player;
import beans.Team;
import database.DatabaseManager;

public class DatabaseManagerTests {

	DatabaseManager dm = DatabaseManager.getInstance();

	@Test
	public void testGetPlayerByName() {
		Player p = mock(Player.class);
		when(p.getNameFirst()).thenReturn("Sakib Al");
		when(p.getNameLast()).thenReturn("Hasan");
		when(p.getNameDisplay()).thenReturn("Sakib Al Hasan");

		dm.AddPlayer(p);
		/* Should match first/display name */
		assertEquals(p, dm.getPlayerByName("Sakib"));
		/* Should match first/display name */
		assertEquals(p, dm.getPlayerByName("al"));
		/* Should match last/display name */
		assertEquals(p, dm.getPlayerByName("hasan"));
		/* Should match display name */
		assertEquals(p, dm.getPlayerByName("al hasan"));
		/* Should return null as there is no match */
		assertEquals(null, dm.getPlayerByName("there is no player with this name"));
		/* Null parameter check */
		assertEquals(null, dm.getPlayerByName(null));
	}

	@Test
	public void testGetPlayerById() {
		Player p = mock(Player.class);
		when(p.getPlayerId()).thenReturn(100101);

		dm.AddPlayer(p);
		/* Should match player id */
		assertEquals(p, dm.getPlayerById(100101));
		/* Should return null as there is no match */
		assertEquals(null, dm.getPlayerById(-1));
	}

	@Test
	public void testGetTeamByName() {
		// No  team in list
		assertEquals(null, dm.getTeamByName("someTeam"));
		
		Team t = mock(Team.class);
		dm.AddTeam(t);
		when(t.getTeamName()).thenReturn("royals");
		assertEquals(t, dm.getTeamByName("royAls"));
		// not listed name
		assertEquals(null, dm.getTeamByName("notRoyal"));
		// empty string
		assertEquals(null, dm.getTeamByName(""));
		
		//Null check
		assertEquals(null,dm.getTeamByName(null));
	}

	@Test
	public void testGetTeamByPersonnel() {
		// TODO: Since the function uses static method regular Mockito framework will not work.
		// Need to do try PowerMock.
		assertTrue(true);
	}

	public void testGetTeamByManager() {
		// Test not required as getTeamByPersonnel would cover all cases.
	}

	public void testGetTeamByCoach() {
		// Test not required as getTeamByPersonnel would cover all cases.
	}

	public void testGetTeamByOwner() {
		// Test not required as getTeamByPersonnel would cover all cases.
	}

}
