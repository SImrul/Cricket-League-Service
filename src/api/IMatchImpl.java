package api;

import java.util.Date;

import beans.Match;
import beans.PlayGround;
import beans.Squad;
import exceptions.InvalidMatchTimeException;
import exceptions.NameExistsException;
import exceptions.ScheduleConflictException;

public class IMatchImpl implements IMatch {

	@Override
	public Match AddMatch(String matchName, Squad homeSquad, Squad awaySquad, PlayGround ground, Date time)
			throws InvalidMatchTimeException, NameExistsException {
		
		return null;
	}

	@Override
	public Match AddTournamentMatch(String tournamentKey, String matchName, Squad homeSquad, Squad awaySquad,
			PlayGround ground, Date time) throws ScheduleConflictException {
		// TODO Auto-generated method stub
		return null;
	}

}
