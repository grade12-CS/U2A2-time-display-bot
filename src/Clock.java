import becker.robots.*;
import java.awt.Color;
import java.time.LocalTime;

public class Clock {
    private Thread thread1, thread2, thread3, thread4;
    private TimeDigitBot r1, r2, r3, r4;
    private final City field;

    public Clock(City field) {
        this.field = field;
       initializeClock(0, 0); 
    }     

    public Clock(City field, int x_offset, int y_offset) {
        this.field = field;
        initializeClock(x_offset, y_offset);
    }    
    
    private void initializeClock(int x_offset, int y_offset) {
        r1 = new TimeDigitBot(field, x_offset, y_offset);
        r2 = new TimeDigitBot(field, 7 + x_offset, y_offset);
        r3 = new TimeDigitBot(field, 15 + x_offset, y_offset);
        r4 = new TimeDigitBot(field, 22+ x_offset, y_offset);
        //for format
        new Thing(field, 2 + x_offset, 13 + y_offset).setColor(Color.BLACK);
        new Thing(field, 4 + x_offset, 13 + y_offset).setColor(Color.BLACK);

		String time = LocalTime.now().toString();
		System.err.println(time);

		thread1 = new Thread(() -> {
			r1.draw_digit(Character.getNumericValue(time.charAt(0)));
		});
		thread2 = new Thread(() -> {
			r2.draw_digit(Character.getNumericValue(time.charAt(1)));
		});
		thread3 = new Thread(() -> {
			r3.draw_digit(Character.getNumericValue(time.charAt(3)));
		});
		thread4 = new Thread(() -> {
			r4.draw_digit(Character.getNumericValue(time.charAt(4)));
		});
    }
    
    public void start() {
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    public void setRobotTransparencies(double value) {
        r1.setTransparency(value);
        r2.setTransparency(value);
        r3.setTransparency(value);
        r4.setTransparency(value);
    }

    public void setRobotColors(Color color) {
        r1.setRobotColor(color);
        r2.setRobotColor(color);
        r3.setRobotColor(color);
        r4.setRobotColor(color);
    }
}
