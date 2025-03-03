import becker.robots.*;
 
public class RobotTask {

	/**
	 * perform functions declared in it.
	 */
	public void run() {
		// build a random city called waterloo
		City waterloo = new City(100, 100);

		int num = 1;

		Number0 botZero = new Number0(waterloo, 0, 0, Direction.EAST, 100);
		botZero.printAndLocate(num);
		num++;

		Number1 botOne = new Number1(waterloo, 0, 3, Direction.EAST, 100);
		botOne.printAndLocate(num);
		num++;

		Number2 botTwo = new Number2(waterloo, 0, 6, Direction.EAST, 100);
		botTwo.printAndLocate(num);
		num++;

		Number3 botThree = new Number3(waterloo, 0, 9, Direction.EAST, 100);
		botThree.printAndLocate(num);
		num++;

		Number4 botFour = new Number4(waterloo, 0, 12, Direction.EAST, 100);
		botFour.printAndLocate(num);
		num++;
		
	}
}
