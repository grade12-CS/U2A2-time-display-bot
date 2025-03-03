/**
 * a class for 2d coordinates
 */
public class Point {
	public int x, y;

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
}