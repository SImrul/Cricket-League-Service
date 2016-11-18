package util;

import java.io.Serializable;

/**
 * A Key class should be used to identify unique objects in the application.
 * Items which can be searchable should use key.
 * 
 * @author IS035688
 *
 */
public class Key implements Serializable{
	/* Upper-case character sequence */
	private String value;

	public Key(String value) {
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return this.value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this.getValue() == null || this.getValue().trim().length() == 0)
			return false;
		if (!(obj instanceof Key) || obj == null)
			return false;
		Key k = (Key) obj;
		if (this.value.equalsIgnoreCase(k.getValue()))
			return true;
		else
			return false;
	}

	public String getValue() {
		return value;
	}
	
}
