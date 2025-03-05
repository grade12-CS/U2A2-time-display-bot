import becker.robots.*;

public abstract class NumberBot extends RobotAdvanced {
    public NumberBot(City city, int x, int y, Direction direction, int things) {
        super(city, x, y, direction, things);
    }

    public NumberBot(City city, int x, int y) {
        super(city, x, y);
    }

    public abstract void drawDigit(int digit);

    public abstract void remove();
}
