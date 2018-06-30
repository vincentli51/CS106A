
import stanford.karel.*;

public class UnitedNationsKarel extends SuperKarel {
	
	public void run() {
		while (frontIsClear()) {
			move();
			if (beepersPresent()) {
				buildHouse();
			}
		}
	}
	
	private void buildHouse() {
		pickBeeper();
		move();
		turnLeft();
		buildWall();
		turnLeft();
		move();
		move();
		turnRight();
		buildWall();
		turnRight();
		move();
		turnLeft();
		move();
		buildWall();
		turnAround();
		move();
		turnLeft();
		move();
	}
	
	private void buildWall() {
		for (int i=0; i<3; i++) {
			putBeeper();
			move();
		}
		turnAround();
		for (int i=0; i<3; i++) {
			move();
		}
		turnAround();
	}
}
