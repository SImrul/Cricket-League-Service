package api;

import util.Key;

/**
 * The interface establishes a standard mechanism to find different object using
 * the {@link Key}.
 * 
 * @author IS035688
 *
 */
public interface Searchable {

	/**
	 * The implementor should generate a key object and return it. Failure to
	 * generate may yield NULL.
	 * 
	 * @return
	 */
	public Key generateKey();

	/**
	 * Find object using the key or NULL if not found.
	 * 
	 * @param key
	 * @return
	 */
	public Searchable findByKey(Key key);
}
