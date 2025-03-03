/**
 * a class for 2d coordinates
 */
public class Point {
	public int x, y;
	public boolean putThing = true;

	/**
	 * 
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * creates a zero point (0, 0).
	 */
	public Point() {
		this.x = 0;
		this.y = 0;
	}

	public Point(int x, int y, boolean putThing) {
		this.x = x;
		this.y = y;
		this.putThing = putThing;
	}

	public Point minus(Point point) {
		return new Point(x - point.x, y - point.y);
	}

	public Point plus(Point point) {
		return new Point(x + point.x, y + point.y);
	}

	public Point times(Point point) {
		return new Point(x * point.x, y * point.y);
	}
}