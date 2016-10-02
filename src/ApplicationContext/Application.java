package ApplicationContext;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import beans.Player;
import beans.Team;

public class Application {

	public static void main(String[] args) {	
		ApplicationContext beanContext = new FileSystemXmlApplicationContext("beans.xml");
		
		
		Team team1 = (Team)beanContext.getBean("team");
		List<Player> teamMembers = team1.getPlayers();
		System.out.println(teamMembers);
	}
}
