import becker.robots.*;
import java.awt.Color;
 
public class RobotTask {

	/**
	 * perform functions declared in it.
	 */
	public void run() {
		City field = new City(100, 100);
		HourMinuteClock clock1 = new HourMinuteClock(field, 4, 2);
		clock1.setRobotTransparencies(0.3);
		clock1.setRobotColors(Color.BLUE);
		clock1.setRobotSpeeds(50);

		SecondsClock clock2 = new SecondsClock(field, 12, 11);
		clock2.setRobotTransparencies(0.3);
		clock2.setRobotSpeeds(90);

		clock1.start();	
		clock2.start();
	}
}
