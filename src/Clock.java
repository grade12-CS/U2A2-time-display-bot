import becker.robots.*;
import java.awt.Color;
import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * Clock clss using robots and multithreaded
 */
public class Clock {
    private Thread thread1, thread2, thread3, thread4;
    private TimeDigitBot r1, r2, r3, r4;
    private final City field;

    /**
     * creates a clock 
     * @param field field to display time
     * *default clock position: (0, 0)
     */
    public Clock(City field) {
        this.field = field;
       initializeClock(0, 0); 
    }     

    /**
     * creates a clock 
     * @param field field to display time
     * @param x_offset clock position x offset
     * @param y_offset clock position y offset
     */
    public Clock(City field, int x_offset, int y_offset) {
        this.field = field;
        initializeClock(x_offset, y_offset);
    }    
    
    /**
     * initializes robots and threads needed to function clock.
     * displays time in HH : MM
     * @param x_offset clock position x offset
     * @param y_offset clock position y offset
     */
    private void initializeClock(int x_offset, int y_offset) {
        r1 = new TimeDigitBot(field, x_offset, y_offset);
        r2 = new TimeDigitBot(field, 7 + x_offset, y_offset);
        r3 = new TimeDigitBot(field, 15 + x_offset, y_offset);
        r4 = new TimeDigitBot(field, 22+ x_offset, y_offset);

        //for format
        new Thing(field, 2 + x_offset, 13 + y_offset).setColor(Color.BLACK);
        new Thing(field, 4 + x_offset, 13 + y_offset).setColor(Color.BLACK);

		thread1 = new Thread(() -> {
            scheduleUpdate(r1, 0);
		});
		thread2 = new Thread(() -> {
            scheduleUpdate(r2, 1);
		});
		thread3 = new Thread(() -> {
            scheduleUpdate(r3, 3);
		});
		thread4 = new Thread(() -> {
            scheduleUpdate(r4, 4);
		});
    }
    
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);

    public void scheduleUpdate(TimeDigitBot r, int index) {
        scheduler.scheduleWithFixedDelay(() -> {
            String time = LocalTime.now().toString();
            System.out.println(time);
            int digit = Character.getNumericValue(time.charAt(index));
            if (r.lastDrawnDigit == -1) {
                r.drawDigit(digit);
            } else if (r.lastDrawnDigit != digit) {
                r.remove();
                r.drawDigit(digit);
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    /**
     * starts running clock
     */
    public void start() {
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    /**
     * sets trnasparency of robots. (0.0: transparent, 1.0: opaque)
     * @param value transparency
     */
    public void setRobotTransparencies(double value) {
        r1.setTransparency(value);
        r2.setTransparency(value);
        r3.setTransparency(value);
        r4.setTransparency(value);
    }

    /**
     * sets colour of robots 
     * @param color
     */
    public void setRobotColors(Color color) {
        r1.setRobotColor(color);
        r2.setRobotColor(color);
        r3.setRobotColor(color);
        r4.setRobotColor(color);
    }

    public void setRobotSpeeds(double speed) {
        r1.setSpeed(speed);
        r2.setSpeed(speed);
        r3.setSpeed(speed);
        r4.setSpeed(speed);
    }
}
