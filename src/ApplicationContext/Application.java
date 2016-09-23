package ApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import beans.Team;

public class Application {

	public static void main(String[] args) {	
		ApplicationContext beanContext = new FileSystemXmlApplicationContext("beans.xml");
		
		Team team1 = new Team();
	}
}
