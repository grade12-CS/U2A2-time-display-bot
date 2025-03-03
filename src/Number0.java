import becker.robots.City;
import becker.robots.Direction;

public class Number0 extends NumberBot{

    public Number0(City city, int x, int y, Direction direction, int things) {
        super(city, x, y, direction, things);
    }

    @Override
    public void printNum() {
        putThenMove(2, -4);
        putThenMove(-2, 4);
    }

}
