import becker.robots.*;
import java.awt.Color;
import java.util.concurrent.*;

/**
 * clock that only displays seconds
 */
public final class SecondsClock extends Clock {
    /**
     * thread to run at the same time
     */
    private Thread thread1, thread2;
    /**
     * robot to draw digits
     */
    private TimeDigitBot r1, r2;    

    public SecondsClock(City field) {
        super(field);
        initializeClock(0, 0);
    }
    
    public SecondsClock(City field, int x_offset, int y_offset) {
        super(field);
        initializeClock(x_offset, y_offset);
    }

    /**
     * scheduler for time digit robots to redraw digit on time change 
     */
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

    @Override
    protected void initializeClock(int x_offset, int y_offset) {
        r1 = new TimeDigitBot(field, x_offset, y_offset);
        r2 = new TimeDigitBot(field, 7 + x_offset, y_offset);
		thread1 = new Thread(() -> {
            scheduleUpdate(r1, 6, scheduler, 0, 1, TimeUnit.MILLISECONDS);
		});
		thread2 = new Thread(() -> {
            scheduleUpdate(r2, 7, scheduler, 0, 1, TimeUnit.MILLISECONDS);
		});
    }

    @Override
    public void start() {
        thread1.start();
        thread2.start();
    }

    @Override
    public void setRobotTransparencies(double value) {
        r1.setTransparency(value);
        r2.setTransparency(value);
    }

    @Override
    public void setRobotColors(Color color) {
        r1.setRobotColor(color);
        r2.setRobotColor(color);
    }

    @Override
    public void setRobotSpeeds(double speed) {
        r1.setSpeed(speed);
        r2.setSpeed(speed);
    }
}
