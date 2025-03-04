import becker.robots.City;
import becker.robots.Direction;

public class Number6 extends NumberBot{

    public Number6(City city, int x, int y, Direction direction, int things) {
        super(city, x, y, direction, things);
    }

    @Override
    public void printNum() {
        putThenMove(2, 0);
        putThenMove(-2, -4);
        putThenMove(2, 2);
        putThenMove(-2, 0);
    }

}