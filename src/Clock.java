import becker.robots.*;
import java.awt.Color;
import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * Clock clss using robots and multithreaded
 */
public abstract class Clock {
    protected final City field;
    public LocalTime time = LocalTime.now();

    /**
     * creates a clock 
     * @param field field to display time
     * *default clock position: (0, 0)
     */
    public Clock(City field) {
        this.field = field;
        updateTimePeriodically();
    }     

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(0);

    private void updateTimePeriodically() {
        scheduler.scheduleAtFixedRate(() -> {
            time = LocalTime.now();
        }, 0, 1, TimeUnit.MICROSECONDS);
    }

    protected void scheduleUpdate(TimeDigitBot r, int index, ScheduledExecutorService scheduler, long initialDelay, long delay, TimeUnit unit) {
        scheduler.scheduleWithFixedDelay(() -> {
            int digit = Character.getNumericValue(time.toString().charAt(index));
            if (r.lastDrawnDigit == -1) {
                r.drawDigit(digit);
            } else if (r.lastDrawnDigit != digit) {
                r.remove();
                r.drawDigit(digit);
            }
        }, initialDelay, delay, unit);
    }
    
    /**
     * initializes robots and threads needed to function clock.
     * displays time in HH : MM
     * @param x_offset clock position x offset
     * @param y_offset clock position y offset
     */
    protected abstract void initializeClock(int x_offset, int y_offset);
    

    /**
     * schedules time update for each TimeDigitBot. checks time changes in hour and minute digits every seconds. 
     * @param r
     * @param index
     */
    protected abstract void scheduleUpdate(TimeDigitBot r, int index);

    /**
     * starts running clock
     */
    public abstract void start();

    /**
     * sets trnasparency of robots. (0.0: transparent, 1.0: opaque)
     * @param value transparency
     */
    public abstract void setRobotTransparencies(double value);

    /**
     * sets colour of robots 
     * @param color colour of robot to appear
     */
    public abstract void setRobotColors(Color color);

    /**
     * sets speed of robots drawing and removing digits
     * @param speed speed of robot
     */
    public abstract void setRobotSpeeds(double speed);
}
