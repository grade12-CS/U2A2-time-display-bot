import becker.robots.*;
 
public class RobotTask {

	/**
	 * perform functions declared in it.
	 */
	public void run() {
		// build a random city called waterloo
		City waterloo = new City(100, 100);
		
		// build a robot in the city waterloo starting at street 4, avenue 1
		LetterBot r = new LetterBot(waterloo, 1, 1, 999);	
		//r.setSpeed(60);
		r.drawS();
		r.drawA();
		r.drawR();
		r.drawA();
		r.drawH();
	}
}
