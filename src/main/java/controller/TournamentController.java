package controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.ITournament;
import api.TournamentImpl;
import beans.Tournament;

@RestController
public class TournamentController {

	private final AtomicLong counter = new AtomicLong();
	private ITournament _tapi;
	
	public TournamentController() {
		_tapi = new TournamentImpl();
	}
	
	public ITournament get_tapi() {
		return _tapi;
	}
	
	public void set_tapi(ITournament _tapi) {
		this._tapi = _tapi;
	}
	
	/**
	 * Create a new Tournament with given name, if already exists, return the
	 * existing instance and do not create duplicate.
	 * 
	 * @param name tournament name, only alphabet
	 * @return JSON string
	 */
	@RequestMapping("/tournament/add")
	public Tournament addTournament(@RequestParam(value="name", defaultValue="test") String name) {
		//return new Tournament(name);
		return _tapi.createTournament(name);
	}
	
}


//	@RequestMapping("/greetings")
//	public String hello() {
//		System.out.println("ok");
//		return "Hello";
//	}