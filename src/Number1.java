import becker.robots.City;
import becker.robots.Direction;

public class Number1 extends NumberBot{

    public Number1(City city, int x, int y, Direction direction, int things) {
        super(city, x, y, direction, things);
    }

    @Override
    public void printNum() {
        moveForward(2);
        putThenMove(0, -4);
        putThing();
    }

}
