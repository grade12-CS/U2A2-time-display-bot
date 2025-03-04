import becker.robots.City;
import becker.robots.Direction;

public abstract class NumberBot extends RobotAdvanced{

    public NumberBot(City city, int x, int y, Direction direction, int things) {
        super(city, x, y, direction, things);
    }

    public void locate(int num){
        int wantedX = num * 3 - 1;
        int wantedY = 5;

        int currentX = this.getX();
        int currentY = this.getY();

        this.move(wantedX - currentX, - (wantedY - currentY));
    }

    public void printAndLocate(int num){
        printNum();
        putThing();
        locate(num);
    }

    public abstract void printNum();
    
}
