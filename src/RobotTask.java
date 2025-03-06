import becker.robots.*;
import java.awt.Color;
 
public class RobotTask {

	/**
	 * perform functions declared in it.
	 */
	public void run() {
		City field = new City(100, 100);
		//Clock clock = new Clock(field, 5, 5);
		//clock.setRobotTransparencies(0.3);
		//clock.setRobotColors(Color.BLUE);
		//clock.setRobotSpeeds(50);
		//clock.start();	
		TimeDigitBot r = new TimeDigitBot(field, 10, 0);
		var p = r.getPos();
		System.out.println(p.x + " " + p.y);
		r.goTo(4, 5);
	}
}
