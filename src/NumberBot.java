import becker.robots.*;
import java.util.HashMap;

public class NumberBot extends RobotAdvanced {

    public NumberBot(City city, int x, int y, Direction direction, int things) {
        super(city, x, y, direction, things);
    }
   
    public static final HashMap<Integer, Point[]> digitsmap = new HashMap<Integer, Point[]>() {{
        put(0, new Point[]{new Point(4, 0), new Point(0, -6), new Point(-4, 0), new Point(0, 6), new Point(6, 0, false)});
        put(1, new Point[]{new Point(4, 0, false), new Point(0, -7), new Point(2, 7, false)});
        put(2, new Point[]{new Point(4, -3), new Point(-4, -3), new Point(5, 0), new Point(1, 6, false)});
        put(3, new Point[]{new Point(4, -3), new Point(-5, 0), new Point(5, 0, false), new Point(0, -3), new Point(-5, 0), new Point(7, 6, false)});
        put(4, new Point[]{new Point(0, -3), new Point(4, 4), new Point(0, -3, false), new Point(0, -5), new Point(2, 7, false)});
        put(5, new Point[]{new Point(5, 0), new Point(-5, 0, false), new Point(0, -3), new Point(4, -3), new Point(-5, 0), new Point(7, 6, false)});
        put(6, new Point[]{new Point(5, 0), new Point(-5, 0, false), new Point(0, -3), new Point(4, -3), new Point(-4, 3), new Point(6, 3, false)});
        put(7, new Point[]{new Point(4, -6), new Point(2, 6, false)});
        put(8, new Point[]{new Point(4, -6), new Point(-4, 6), new Point(0, -3, false), new Point(4, 0), new Point(2, 3, false)});
        put(9, new Point[]{new Point(4, -6), new Point(-5, 0), new Point(1, 3, false), new Point(4, 0), new Point(-4, 0, false), new Point(0, 3), new Point(6, 0, false)});
    }};
        
    public void draw_digit(int digit) {
        Point[] points = digitsmap.get(digit);
        for (Point point : points) {
            if (point.putThing) {
                putThenMove(point);
            } else {
                move(point);
            }
        }
    }  
}
