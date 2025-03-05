/**
 * a class for coordinatess in 2d coordinates. 
 */
public class Point {
	public int x, y;
	public boolean putThing = true;

	/**
	 * 
	 * @param x x-coordinate (horizontal) 
	 * @param y y-coordinate (vertical) 
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * initializes zero coordinatess (0, 0).
	 */
	public Point() {
		this.x = 0;
		this.y = 0;
	}

	/**
	 * 
	 * @param x x-coordinate (horizontal)
	 * @param y y-coordinate (vertical)
	 * @param putThing if true, put things while traveling, if false, does not put anything. 
	 */
	public Point(int x, int y, boolean putThing) {
		this.x = x;
		this.y = y;
		this.putThing = putThing;
	}

	/**
	 * subtracts current coordinates by the given coordinates. 
	 * @param Point coordinates to subtract.
	 * @return subtracted coordinates.
	 */
	public Point minus(Point delta) {
		return new Point(x - delta.x, y - delta.y);
	}

	/**
	 * adds given coordinates to the current coordinates. 
	 * @param Point coordinates to add.
	 * @return summed coordinates.
	 */
	public Point plus(Point delta) {
		return new Point(x + delta.x, y + delta.y);
	}

	/**
	 * multiplies given coordinates to the current coordinates. 
	 * @param Point coordinates to multiply.
	 * @return multiplied coordinates.
	 */
	public Point times(Point point) {
		return new Point(x * point.x, y * point.y);
	}
}