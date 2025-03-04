import becker.robots.*;
 
public class RobotTask {

	/**
	 * perform functions declared in it.
	 */
	public void run() {
		// build a random city called waterloo
		City waterloo = new City(100, 100);

		int num = 1;

		Number9 robo = new Number9(waterloo, 0, 0, Direction.EAST, 100);
		robo.printAndLocate(num);
		num++;
	}
}
