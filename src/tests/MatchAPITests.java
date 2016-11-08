package tests;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;

import api.IMatch;
import api.IMatchImpl;
import beans.Squad;
import beans.Match;
import beans.Match.MatchType;
import beans.PlayGround;
import database.DatabaseManager;
import exceptions.InvalidMatchTimeException;
import exceptions.NameExistsException;
import exceptions.ScheduleConflictException;

public class MatchAPITests {

	private DatabaseManager db = DatabaseManager.getInstance();
	private IMatch mAPI = new IMatchImpl();

	@Test
	public void CreateGeneralMatchTest() {
		PlayGround mirpur = new PlayGround("Mirpur");
		Match m = null;
		try {
			m = mAPI.AddMatch("Ban Vs Eng 1st ODI", MatchType.ODI, Mockito.mock(Squad.class), Mockito.mock(Squad.class),
					mirpur, new Date());
			assertTrue(m instanceof Match);
			assertEquals(m, db.getGeneralMatch(m.getKey()));
		} catch (ScheduleConflictException e) {
			fail(e.getMessage());
		} catch (NameExistsException e) {
			fail(e.getMessage());
		}
		if(m != null) db.removeMatch(m);
	}
	
	@Test(expected=ScheduleConflictException.class)
	public void CreateTimeConflictMatchTest() throws ScheduleConflictException{
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 31, 10, 0, 0); // 31st Jan 2000 10:00:00
		Date m1Time = c.getTime();
		PlayGround fatullah = new PlayGround("Fatuallah");
		Match m1 = null, m2 = null;
		try {
			m1 = mAPI.AddMatch("Ban Vs Sri Friendly", MatchType.ODI, Mockito.mock(Squad.class),
					Mockito.mock(Squad.class), fatullah, m1Time);
		} catch (ScheduleConflictException e) {
			fail("Couldn't create the first match");
		} catch (NameExistsException e) {
			fail("Couldn't create the first match");
		}
		// The 2nd game scheduled 1 hour after the first, should raise conflict
		c.add(Calendar.HOUR_OF_DAY, 1); // add 1 hours for next game
		Date m2Time = c.getTime();
		try {
			m2 = mAPI.AddMatch("Ban XI Vs Sri Xi Friendly", MatchType.ODI, Mockito.mock(Squad.class),
					Mockito.mock(Squad.class), fatullah, m2Time);
		} catch (NameExistsException e) {
			fail(e.getMessage());
		} catch (ScheduleConflictException e) {
			throw e;
		}
		// Cleanup
		if(m1 != null) db.removeMatch(m1);
		if(m2 != null) db.removeMatch(m2);
		fail("Didn't raise conflict on game time.");
		
		
	}
	
	@Test(expected=ScheduleConflictException.class)
	public void CreateTimeConflictMatch2Test() throws ScheduleConflictException{
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 31, 10, 0, 0); // 31st Jan 2000 10:00:00
		Date m1Time = c.getTime();
		PlayGround fatullah = new PlayGround("Fatuallah");
		Match m1 = null, m3 = null;
		try {
			m1 = mAPI.AddMatch("Ban Vs Sri Friendly", MatchType.ODI, Mockito.mock(Squad.class),
					Mockito.mock(Squad.class), fatullah, m1Time);
		} catch (ScheduleConflictException e) {
			fail("Couldn't create the first match");
		} catch (NameExistsException e) {
			fail("Couldn't create the first match");
		}
		
		// The third game scheduled to start 1 hour before first game, should raise conflict
		c.clear();
		c.set(2000, Calendar.JANUARY, 31, 10, 0, 0); // reset to first game's time
		c.add(Calendar.HOUR_OF_DAY, -1); // 1 hour before
		Date m3Time = c.getTime();
		try {
			m3 = mAPI.AddMatch("Ban Jr Vs Sri Jr Friendly", MatchType.ODI, Mockito.mock(Squad.class),
					Mockito.mock(Squad.class), fatullah, m3Time);
		} catch (NameExistsException e) {
			fail(e.getMessage());
		}
		// Cleanup
		if(m1 != null) db.removeMatch(m1);
		if(m3 != null) db.removeMatch(m3);
		fail("Didn't raise conflict on game time.");
	}

}
