import becker.robots.*;
import java.awt.Color;
import java.util.HashMap;
import java.util.Stack;

/**
 * Extending NumberBot, this a robot class further specialized in drawing and updating time digit in a real-time clock.
 */
public class TimeDigitBot extends NumberBot{
    /**
     *  the last digit robot drew. Initially, the value is -1.
     */
    public int lastDrawnDigit = -1;
    /**
     * a stack storing robot action logs. It is re-track back robot paths and pick up things to remove a digit drawn.
     */
    private final Stack<Point> stk = new Stack<>();

    /**
     * @param city city that will be displayed to the map 
     * @param x the x coordinate of the starting position 
     * @param y the y coordinate of the starting position
     * @param direction initial robot heading
     * @param things initial number of things robot holds
     */
    public TimeDigitBot(City city, int x, int y, Direction direction, int things) {
        super(city, x, y, direction, things);
    }
    
    /**
     * @param city city that will be displayed to the map 
     * @param x the x coordinate of the starting position 
     * @param y the y coordinate of the starting position
     */
    public TimeDigitBot(City city, int x, int y) {
        super(city, x, y);
    }

    /**
     * maps of digit drawing path. 
     */
    public static final HashMap<Integer, Point[]> digitsmap = new HashMap<Integer, Point[]>() {{
        put(0, new Point[]{new Point(4, 0), new Point(0, -6), new Point(-4, 0), new Point(0, 6), new Point(6, 0, false)});
        put(1, new Point[]{new Point(4, 0, false), new Point(0, -7), new Point(2, 7, false)});
        put(2, new Point[]{new Point(4, -3), new Point(-4, -3), new Point(5, 0), new Point(1, 6, false)});
        put(3, new Point[]{new Point(4, -3), new Point(-5, 0), new Point(5, 0, false), new Point(0, -3), new Point(-5, 0), new Point(7, 6, false)});
        put(4, new Point[]{new Point(0, -3), new Point(4, 4), new Point(0, -3, false), new Point(0, -5), new Point(2, 7, false)});
        put(5, new Point[]{new Point(5, 0), new Point(-5, 0, false), new Point(0, -3), new Point(4, -3), new Point(-5, 0), new Point(7, 6, false)});
        put(6, new Point[]{new Point(5, 0), new Point(-5, 0, false), new Point(0, -3), new Point(4, -3), new Point(-4, 3), new Point(6, 3, false)});
        put(7, new Point[]{new Point(4, -7), new Point(2, 7, false)});
        put(8, new Point[]{new Point(4, -6), new Point(-4, 6), new Point(0, -3, false), new Point(4, 0), new Point(2, 3, false)});
        put(9, new Point[]{new Point(4, -6), new Point(-5, 0), new Point(1, 3, false), new Point(4, 0), new Point(-4, 0, false), new Point(0, 3), new Point(6, 0, false)});
    }};

    /**
     * draws the requested digit
     */
    @Override
    public void drawDigit(int digit) {
        lastDrawnDigit = digit;
        randomlySetThingColor();
        Point[] points = digitsmap.get(digit);
        for (Point point : points) {
            stk.push(point);
            if (point.putThing) {
                putThenMove(point);
            } else {
                move(point);
            }
        }
    }

    /**
     * removes the last drawn digit until robot's action log stack is empty
     */
    @Override
    public void remove() {
        while (!stk.isEmpty()) {
            Point p = stk.lastElement();
            Direction dir = (p.y > 0) ? Direction.SOUTH : Direction.NORTH;
            turn(dir);
            repeat(() -> {
                while (canPickThing()) {
                    pickThing();
                }
                move();
            }, Math.abs(p.y));
            dir = (p.x > 0) ? Direction.WEST : Direction.EAST;
            turn(dir);
            repeat(() -> {
                while (canPickThing()) {
                    pickThing();
                }
                move();
            }, Math.abs(p.x));
            stk.pop();
        }
    }

    /**
     * clears robot's action logs stack
     */
    public void clearLogs() {
        stk.clear();
    }

    /**
     * assign a random RGB color to thing robot will put.
     */
    public void randomlySetThingColor() {
        int r = (int) (Math.round(Math.random() * 255));
        int g = (int) (Math.round(Math.random() * 255));
        int b = (int) (Math.round(Math.random() * 255));
        Color color = new Color(r, g, b);
        setThingColor(color);
    }
}
