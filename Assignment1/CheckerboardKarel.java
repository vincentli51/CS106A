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

	/**
	 * Karel fill the world with beepers in a checkerboard pattern 
	 * @precondition Karel is facing East on the bottom left corner
	 * @postcondition Karel is on the same avenue, either on the top facing facing west 
	 * or on the bottom facing south
	 */
	public void run() {
		putBeeper();
		while (frontIsClear()) {
			oneLine();
			turnRight();
			if (frontIsClear()) {
				move();
				turnRight();
			}
			if (frontIsClear()) {
				move();
				if (noBeepersPresent()) {
					putBeeper();
				}
				oneLine();
			}
			if (noBeepersPresent()) {
				turnRight();
			}
			if (frontIsClear()) {
				move();
				turnRight();
			}
		}
		turnLeft();
		if ((frontIsClear()) && (beepersPresent())) {	
			oneLine();
		}
	}

	/**
	 * Karel fills a stret with beepers in a pattern.
	 * @precondition Karel is facing the direction of a street 
	 * @postcondition Karel is in the same spot she started in, but looking the opposite direction
	 */
	private void oneLine() {
		while (frontIsClear()) {
			movingForward();
		}
		turnAround();
		if (frontIsClear()) {
			move();
		}
		checkOK();
		while (frontIsClear()) {
			move();
		}
	}

	/**
	 * Karel checks if the pattern is correct by taking a step back to the end of the street and 
	 * checking whether a beeper belong in the spot
	 * @precondition Karel is facing the opposite direction in which it has filled the street
	 * @postcondition Karel is facing the same direction, but one corner back
	 */
	private void checkOK() {
		if (noBeepersPresent() && frontIsClear()) {
			turnAround();
			if (frontIsClear()) {
				move();
			}
			if (noBeepersPresent()) {
				putBeeper();
			}
			turnAround();
		} else {
			if (frontIsClear()) {
				move();
			}
		}
	}

	/**
	 * Karel is placing a beeper then moving twice, if allowed, to achieve the checkboard pattern
	 * @precondition Karel is facing a direction
	 * @postcondition Karel is at max 2 avenues down in the direction it was facing
	 */
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

