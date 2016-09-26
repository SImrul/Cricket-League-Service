package tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import beans.Player;
import database.DatabaseManager;

public class DatabaseManagerTests {

	DatabaseManager dm = new DatabaseManager();
	
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
}
