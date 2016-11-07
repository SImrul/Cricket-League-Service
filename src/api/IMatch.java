package api;

import java.util.Date;

import beans.Match;
import beans.PlayGround;
import beans.Squad;
import exceptions.InvalidMatchTimeException;
import exceptions.NameExistsException;
import exceptions.ScheduleConflictException;

public interface IMatch {

	/**
	 * Create an ordinary match. Throw exception when name pre-exists or Squad
	 * don't have team defined or playground NULL or time in past.
	 * 
	 * @param matchName
	 * @param homeSquad
	 * @param awaySquad
	 * @param ground
	 * @param time
	 * @return Match object
	 * @throws InvalidMatchTimeException
	 * @throws NameExistsException
	 */
	public Match AddMatch(String matchName, Squad homeSquad, Squad awaySquad, PlayGround ground, Date time)
			throws InvalidMatchTimeException, NameExistsException, Exception;
	
	
	/**
	 * Create a match and add it in tournament Schedule. Throw exception when
	 * schedule conflicts like another match exists in same time & venue or
	 * either team has match in same time.
	 * 
	 * @param tournamentKey
	 * @param matchName
	 * @param homeSquad
	 * @param awaySquad
	 * @param ground
	 * @param time
	 * @return Match object or NULL
	 */
	public Match AddTournamentMatch(String tournamentKey, String matchName, Squad homeSquad, Squad awaySquad,
			PlayGround ground, Date time) throws ScheduleConflictException;
}
