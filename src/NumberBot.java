import becker.robots.*;

public abstract class NumberBot extends RobotAdvanced {
    public NumberBot(City city, int x, int y, Direction direction, int things) {
        super(city, x, y, direction, things);
    }

    public abstract void draw_digit(int digit);
}
