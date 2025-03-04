import becker.robots.*;
import java.time.LocalTime;
 
public class RobotTask {

	/**
	 * perform functions declared in it.
	 */
	public void run() {
		// build a random city called waterloo
		City waterloo = new City(100, 100);
		NumberBot r = new NumberBot(waterloo, 0, 0, Direction.NORTH, 999);

		String time = LocalTime.now().toString();
		System.err.println(time);

		for (char c : time.toCharArray()) {
			System.err.println(c);
			if (Character.isDigit(c)) {
				r.draw_digit(Character.getNumericValue(c));
			} 
		}
	}
}
