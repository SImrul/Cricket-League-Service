package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import beans.Personnel;
import beans.Personnel.ROLE;
import util.PersonnelUtil;

public class PersonnelUtilTests {

	PersonnelUtil pu = PersonnelUtil.getInstance();
	
	@Test
	public void testIsSamePersonnel() {
		Personnel p1 = new Personnel("First","Last","First Last", ROLE.COACH, new Date());
		Personnel p2 = new Personnel("First","Last","First Last", ROLE.COACH, new Date());
		Personnel p3 = new Personnel("First","Last3","First Last3", ROLE.COACH, new Date());
		Personnel p4 = new Personnel("First","Last","First Last", ROLE.TEAM_OWNER, new Date());
		
		assertTrue(pu.isSamePersonnel(p1, p2));
		assertFalse(pu.isSamePersonnel(p1, p3));
		assertFalse(pu.isSamePersonnel(p1, p4));
		
		// Null check
		Personnel nulltype = new Personnel(null, null, null, ROLE.COACH, null);
		assertFalse(pu.isSamePersonnel(p1, null));
		assertFalse(pu.isSamePersonnel(null, p2));
		assertFalse(pu.isSamePersonnel(null, null));
		assertFalse(pu.isSamePersonnel(p1, nulltype));
		assertFalse(pu.isSamePersonnel(nulltype, p2));
	}
}
