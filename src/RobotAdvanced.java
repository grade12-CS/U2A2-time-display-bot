import becker.robots.*;
import java.awt.Color;

/**
 * includes advanced methods utilizing points 
 */
public class RobotAdvanced extends RobotSE {
    private Color thingColor = Color.BLACK;

    /**
     * @param city city that will be displayed to the map 
     * @param x the x coordinate of the starting position 
     * @param y the y coordinate of the starting position
     * @param direction initial robot heading
     * @param things initial number of things robot holds
     */
    public RobotAdvanced(City city, int x, int y, Direction direction, int things) {
        super(city, y, x, direction, things);
    }

    /**
     * @param city city that will be displayed to the map 
     * @param x the x coordinate of the starting position
     * @param y the y coordinate of the starting position 
     * @param direction initial robot heading
     * @param things initial number of things robot holds
     * *default number of things: 999.
     */
    public RobotAdvanced(City city, int x, int y, Direction direction) {
        super(city, y, x, direction, 999);
    }

    /**
     * @param city city that will be displayed to the map 
     * @param x the x coordinate of the starting position 
     * @param y the y coordinate of the starting position 
     * @param things initial number of things robot holds
     * *default heading: North.
     */
    public RobotAdvanced(City city, int x, int y, int things) {
        super(city, y, x, Direction.NORTH, things);
    }

    /**
     * @param city city that will be displayed to the map 
     * @param x the x coordinate of the starting position 
     * @param y the y coordinate of the starting position 
     * *default heading: North.
     */
    public RobotAdvanced(City city, int x, int y) {
        super(city, y, x, Direction.NORTH, 999);
    }

    /**
     * 
     * @return returns the x coordinate (avenue) of the current robot position on the map.
     */
    public int getX() {
        return getAvenue();
    }

    /**
     * 
     * @return the y coordinate (street) of the current robot position on the map.
     */
    public int getY() {
        return getStreet();
    }

    /**
     * 
     * @return current position in 2d coordinates
     */
    public Point getPos() {
        return new Point(getX(), getY());
    }

    /**
     * turns robot around by turning left twice.
     */
    public void turnBack() {
        turnLeft();
        turnLeft();
    }
   
    /**
     * turns robot according to the direction.
     * @param target_direction the direction robot will head.
     */
    public void turn(Direction target_direction) {
        Direction current_direction = getDirection();
        if (current_direction == target_direction) return;
        if (current_direction.left() == target_direction) {
            turnLeft();
        } else if (current_direction.right() == target_direction) {
            turnRight();
        } else {
           turnBack(); 
        }
    } 

    /**
	 * Repeates a runnable function for t times.
	 * @param func function to run
	 * @param t the number of times to repeat the function.
	 */
    public void repeat(Runnable func, int t) {
        for (int i = 0; i < t; ++i) {
            func.run();
        }
    }

	/**
	 * Moves the robot n spaces forward.
	 * @param n the number of spaces to move
	 */
    public void moveForward(int n) {
        if (n <= 0) return;
        repeat(() -> {
            move();
        }, n);
    }

    /**
     * turns robot first and then move n spaces forward.
     * @param direction Direction to turn
     * @param n the number of spaces to move 
     */
    public void turnThenMove(Direction direction, int n) {
        turn(direction);
        moveForward(n);
    }

    /**
     * turns robot first and then move 1 space forward.
     * @param direction Direction to turn
     */
    public void turnThenMove(Direction direction) {
        turn(direction);
        moveForward(1);
    }

    /**
     * moves robot x spaces horizontally and y spaces vertically. 
     *  @param x the x coordinate robot will move to
     *  @param y the y coordinate robot will move to
     */
    public void move(int x, int y) {
        turnThenMove(x > 0 ? Direction.EAST : Direction.WEST, Math.abs(x));
        turnThenMove(y > 0 ? Direction.NORTH : Direction.SOUTH, Math.abs(y)); 
    }

    public void move(Point point) {
        move(point.x, point.y);
    }

    /**
     * moves robot x spaces horizontally and y spaces vertically while putting things. 
     * @param x the x coordinate robot will move to
     * @param y the y coordinate robot will move to
     */
    public void putThenMove(int x, int y) {
        turn(x > 0 ? Direction.EAST : Direction.WEST);
        repeat(() -> {
            putThing();
            move();
        }, Math.abs(x));
        turn(y > 0 ? Direction.NORTH : Direction.SOUTH);
        repeat(() -> {
            putThing();
            move();
        }, Math.abs(y));
    }

    /**
     * 
     * @param point point to move
     */
    public void putThenMove(Point point) {
        putThenMove(point.x, point.y);
    }

    /**
     * 
     * @param color colour of thing to put. puts thing at the current robot's position
     */
    public void putThing(Color color) {
        new Thing(getCity(), getY(), getX()).setColor(color);
    }
    
    /**
     * puts thing in defined colour of thing
     */
    @Override
    public void putThing() {
        putThing(thingColor);
    }
    
    /**
     *  goes to the designated point relative to the field 
     *  @param x the x coordinate robot will go to
     *  @param y the y coordinate robot will go to
     */
    public void goTo(int x, int y) {
        move(x - getX(), getY() - y);
    }

    /**
     * goes to the designated point relative to the field
     * @param point the point the robot will go to.
     */
    public void goTo(Point point) {
        goTo(point.x, point.y);
    }

    /**
     * sets robot's transparency. (transparent at 0.0, opaque at 1.0)
     * @param value transparency of robot (0.0 ~ 1.0) 
     */
    @Override
    public void setTransparency(double value) {
        getIcon().setTransparency(Math.abs(1 - value));
    }

    /**
     * sets colour of robot
     * @param color colour of robot to change
     */
    public void setRobotColor(Color color) {
        getIcon().setColor(color);
    }

    /**
     * sets colour of thing
     * @param color colour of thing to change
     */
    public void setThingColor(Color color) {
        this.thingColor = color;
    }
}

