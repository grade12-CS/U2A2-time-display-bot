import becker.robots.*;
import java.awt.Color;
 
public class RobotTask {

	/**
	 * perform functions declared in it.
	 */
	public void run() {
		City field = new City(100, 100);
		Clock clock = new Clock(field, 5, 5);
		clock.setRobotTransparencies(0.3);
		clock.setRobotColors(Color.BLUE);
		clock.setRobotSpeeds(50);
		clock.start();	
	}
}
