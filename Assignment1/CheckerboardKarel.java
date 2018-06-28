/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		while (frontIsClear()) {
			while (frontIsClear()) {
				oneLine();
			}		
			if (frontIsBlocked()) {
				turnRight();
				if (frontIsClear()) {
					move();
					turnRight();
				}	
				if (frontIsClear()) {
					move();
				}
			}
			if (frontIsClear()) {
				oneLine();
			}
			if (noBeepersPresent()) {
				turnRight();
				if (frontIsClear()) {
					move();
					turnRight();
				}	
			}
		}
		if (frontIsBlocked() && noBeepersPresent()) {
			turnLeft();
			if (frontIsClear()) {
				oneLine();
			}
		}
	}



	private void oneLine() {
		while (frontIsClear()) {
			movingForward();
		}

		if (frontIsBlocked()) {
			turnAround();
		}
		if (frontIsClear()) {
			move();
		}
		if (noBeepersPresent() && frontIsClear()) {
			turnAround();
			move();
			putBeeper();
			turnAround();
		} else {
			move();
		}
		while (frontIsClear()) {
			move();
		}
	}
	private void movingForward() {
		while (noBeepersPresent()) {
			putBeeper();
		}
		if (frontIsClear()) {
			move();
		}
		if (frontIsClear()) {
			move();
		}
	}		
}