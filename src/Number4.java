import becker.robots.City;
import becker.robots.Direction;

public class Number4 extends NumberBot{

    public Number4(City city, int x, int y, Direction direction, int things) {
        super(city, x, y, direction, things);
    }

    @Override
    public void printNum() {
        putThenMove(0, -2);
        putThenMove(2, 2);
        putThenMove(0, -4);
    }

}