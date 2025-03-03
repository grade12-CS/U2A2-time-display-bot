import becker.robots.*;

/**
 * A robot specialized in writing capital letters, extended from Robot class. 
 */
public class LetterBot extends RobotAdvanced {
	/**
	 * 
	 * @param city city of the map
	 * @param x x coordinate of the starting point
	 * @param y y coordinate of the starting point
	 * @param direction direction of the robot's initial heading
	 * @param things initial amounts of Things that robot starts with
	 */
    public LetterBot(City city, int x, int y, Direction direction, int things) {
        super(city, x, y, direction, things);
    } 

	/**
	 * 
	 * @param city city of the map
	 * @param x x coordinate of the starting point
	 * @param y y coordinate of the starting point
	 * @param things initial amounts of Things that robot starts with
	 */
	public LetterBot(City city, int x, int y, int things) {
        super(city, x, y, Direction.NORTH, things);
    }

	/**
	 * Write a capital letter of S by putting Things.
	 */
    public void drawS() {
		move(1, 0);
        putThenMove(4, 0);	
		move(-5, -1);
		putThenMove(0, -2);
		move(1, 0);
        putThenMove(4, 0);	
		move(0, -1);
        putThenMove(0, -2);	
		move(-1, 0);
		putThenMove(-4, 0);
		move(6, 0);
    }
    
	/**
	 * Write a capital letter of A by putting Things.
	 */
    public void drawA() {
		putThenMove(0, 6);
		putThenMove(5, 0);
		putThenMove(0, -3);
		putThenMove(-5, 0);
		move(5, 0);
		putThenMove(0, -4);
		move(1, 1);
    }
    
	/**
	 * Write a capital letter of R by putting Things.
	 */
    public void drawR() {
		putThenMove(0, 6);
		putThenMove(5, 0);
		putThenMove(0, -3);
		putThenMove(-5, 0);
		move(3, -1);
		putThenMove(0, -1);
		move(1, 0);
		putThenMove(0, -1);
		move(1, 0);
		putThenMove(0, -1);
		move(1, 1);
    }

	/**
	 * Write a capital letter of H by putting Things.
	 */
    public void drawH() {
		putThenMove(0, 7);
		move(0, -4);
		putThenMove(5, 0);
		move(0, 3);
		putThenMove(0, -7);
		move(1, 1);
    }
}
