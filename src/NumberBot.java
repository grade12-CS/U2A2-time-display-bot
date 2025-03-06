import becker.robots.*;

/**
 * abstract class of Robot specialized for drawing numbers.
 */
public abstract class NumberBot extends RobotAdvanced {
    /**
     * @param city city that will be displayed to the map 
     * @param x the x coordinate of the starting position 
     * @param y the y coordinate of the starting position
     * @param direction initial robot heading
     * @param things initial number of things robot holds
     */
    public NumberBot(City city, int x, int y, Direction direction, int things) {
        super(city, x, y, direction, things);
    }

    /**
     * @param city city that will be displayed to the map 
     * @param x the x coordinate of the starting position 
     * @param y the y coordinate of the starting position
     */
    public NumberBot(City city, int x, int y) {
        super(city, x, y);
    }

    /**
     * abstract method of drawing digit. A number bot can have different drawing behaviours depending on their responsible number.
     * @param digit digit to draw
     */
    public abstract void drawDigit(int digit);

    /**
     * abstract method of removing drawings. This can be either removing one digit or all digits depending on the use of a robot.
     */
    public abstract void remove();
}
