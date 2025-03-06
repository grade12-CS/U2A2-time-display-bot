import becker.robots.*;
import java.awt.Color;
import java.util.concurrent.*;

/**
 * Clock that only displays hours and minutes.
 */
public final class HourMinuteClock extends Clock {
    private Thread thread1, thread2, thread3, thread4;
    private TimeDigitBot r1, r2, r3, r4;
    /**
     * helps schedule time update for each thread of robot.
     */
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);

    public HourMinuteClock(City field) {
        super(field);
       initializeClock(0, 0); 
    }     

    /**
     * creates a clock 
     * @param field field to display time
     * @param x_offset clock position x offset
     * @param y_offset clock position y offset
     */
    public HourMinuteClock(City field, int x_offset, int y_offset) {
        super(field);
        initializeClock(x_offset, y_offset);
    }

    @Override
    protected void initializeClock(int x_offset, int y_offset) {
        r1 = new TimeDigitBot(field, x_offset, y_offset);
        r2 = new TimeDigitBot(field, 7 + x_offset, y_offset);
        r3 = new TimeDigitBot(field, 15 + x_offset, y_offset);
        r4 = new TimeDigitBot(field, 22+ x_offset, y_offset);

        //for format
        new Thing(field, 2 + y_offset, 13 + x_offset).setColor(Color.BLACK);
        new Thing(field, 4 + y_offset, 13 + x_offset).setColor(Color.BLACK);

		thread1 = new Thread(() -> {
            scheduleUpdate(r1, 0, scheduler, 0, 1, TimeUnit.SECONDS);
		});
		thread2 = new Thread(() -> {
            scheduleUpdate(r2, 1, scheduler, 0, 1, TimeUnit.SECONDS);
		});
		thread3 = new Thread(() -> {
            scheduleUpdate(r3, 3, scheduler, 0, 1, TimeUnit.SECONDS);
		});
		thread4 = new Thread(() -> {
            scheduleUpdate(r4, 4, scheduler, 0, 1, TimeUnit.SECONDS);
		});
    }
    

    @Override
    public void start() {
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    @Override
    public void setRobotTransparencies(double value) {
        r1.setTransparency(value);
        r2.setTransparency(value);
        r3.setTransparency(value);
        r4.setTransparency(value);
    }
    @Override
    public void setRobotColors(Color color) {
        r1.setRobotColor(color);
        r2.setRobotColor(color);
        r3.setRobotColor(color);
        r4.setRobotColor(color);
    }

    @Override
    public void setRobotSpeeds(double speed) {
        r1.setSpeed(speed);
        r2.setSpeed(speed);
        r3.setSpeed(speed);
        r4.setSpeed(speed);
    }
}
