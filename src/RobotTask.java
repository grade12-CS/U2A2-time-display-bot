import becker.robots.*;
 
public class RobotTask {

	/**
	 * perform functions declared in it.
	 */
	public void run() {
		// build a random city called waterloo
		City waterloo = new City(100, 100);
		NumberBot r = new NumberBot(waterloo, 0, 0, Direction.NORTH, 999);
		for (int i = 0; i <= 4; ++i) {
			r.draw_digit(i);
		}
	}
}
