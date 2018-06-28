
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

	public void run() {
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
			} else {
				checkAvenue();
				move();
			}
		}
		if (noBeepersPresent()) {
			checkAvenue();
		}
	}
	private void checkAvenue() {
		turnLeft();
		move();
		pickAllBeepers();
		turnAround();
		move();
		move();
		pickAllBeepers();
		turnAround();
		move();
		turnRight();
	}
	private void pickAllBeepers() {
		while (beepersPresent()) {
			pickBeeper();
		}
	}
	
}
