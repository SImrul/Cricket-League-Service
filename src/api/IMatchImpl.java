package api;

import java.util.Date;

import beans.Match;
import beans.PlayGround;
import beans.Squad;
import beans.Match.MatchType;
import database.DatabaseManager;
import exceptions.NameExistsException;
import exceptions.ScheduleConflictException;

public class IMatchImpl implements IMatch {

	private DatabaseManager db = DatabaseManager.getInstance();
	
	@Override
	public Match AddMatch(String matchName, MatchType mType, Squad homeSquad, Squad awaySquad, PlayGround ground, Date time)
			throws NameExistsException, ScheduleConflictException {
		Match match = new Match(matchName, homeSquad, awaySquad, mType);
		match.setStartTime(time);
		return db.addGeneralMatch(match, ground) ? match : null; 
	}

	@Override
	public Match AddTournamentMatch(String tournamentKey, String matchName, MatchType mType, Squad homeSquad, Squad awaySquad,
			PlayGround ground, Date time) throws ScheduleConflictException {
		// TODO Auto-generated method stub
		return null;
	}

}
