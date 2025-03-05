import becker.robots.*;
import java.time.LocalTime;
 
public class RobotTask {

	/**
	 * perform functions declared in it.
	 */
	public void run() {
		// build a random city called waterloo
		City field = new City(100, 100);
		TimeBot r1 = new TimeBot(field, 0, 0);
		TimeBot r2 = new TimeBot(field, 0, 7);
		TimeBot r3 = new TimeBot(field, 0, 13);
		TimeBot r4 = new TimeBot(field, 0, 20);
		
		//for format
		new Thing(field, 2, 14);
		new Thing(field, 4, 14);
		
		String time = LocalTime.now().toString();
		System.err.println(time);

		Thread thread1 = new Thread(() -> {
			r1.draw_digit(Character.getNumericValue(time.charAt(0)));
		});
		Thread thread2 = new Thread(() -> {
			r2.draw_digit(Character.getNumericValue(time.charAt(1)));
		});
		Thread thread3 = new Thread(() -> {
			r3.draw_digit(Character.getNumericValue(time.charAt(3)));
		});
		Thread thread4 = new Thread(() -> {
			r4.draw_digit(Character.getNumericValue(time.charAt(4)));
		});
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}
