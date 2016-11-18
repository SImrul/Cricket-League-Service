package util;

import beans.Personnel;

public class PersonnelUtil {

	private static PersonnelUtil instance;

	private PersonnelUtil() {
	}

	public static PersonnelUtil getInstance() {
		if (instance == null)
			instance = new PersonnelUtil();
		return instance;
	}

	public boolean isSamePersonnel(Personnel p1, Personnel p2) {
		if (p1 == null || p2 == null) {
			return false;
		} else if (p1.getFirstName() == null || p1.getLastName() == null || p2.getFirstName() == null
				|| p2.getLastName() == null) {
			return false;
		}

		if (p1.getFirstName().equalsIgnoreCase(p2.getFirstName()) && p1.getLastName().equalsIgnoreCase(p2.getLastName())
				&& p1.getRole() == p2.getRole()) {
			return true;
		} else {
			return false;
		}
	}
}
