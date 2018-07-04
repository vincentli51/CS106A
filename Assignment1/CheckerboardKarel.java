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
	 * @postcondition Karel is on the same avenue facing the opposite direction she began
	 */
	public void run() {
		putBeeper();
		while (frontIsClear()) {
			fillsOneStreet();
			turnRight();
			allowedMovement();
			if (frontIsClear()) {
				turnRight();
				allowedMovement();
			}
			fillsOneStreet();
			if (noBeepersPresent()) {
				turnRight();
				allowedMovement();
				turnRight();
			}
		}
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnRight();
		if (noBeepersPresent()) {
			allowedMovement();
		}
		if (noBeepersPresent()) {
			putBeeper();
		}
		fillsOneStreet();
	}
	
	

	/**
	 * Karel fills a street with beepers in a pattern.
	 * @precondition Karel is facing the direction of a street 
	 * @postcondition Karel is in the same spot she started in, but looking the opposite direction
	 */
	private void fillsOneStreet() {
		while (frontIsClear()) {
			putBeeperAndSkip();
		}
		turnAround();
		allowedMovement();
		safeMove();
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
	private void safeMove() {
		if (noBeepersPresent() && frontIsClear()) {
			turnAround();
			allowedMovement();
			if (noBeepersPresent()) {
				putBeeper();
			}
			turnAround();	
		}
	}


	/**
	 * Karel places a beepers then skips the next corner
	 * @precondition Karel is facing a direction
	 * @postcondition Karel is at max 2 avenues down in the direction it was facing
	 */
	private void putBeeperAndSkip() {
		if (noBeepersPresent()) {
		    putBeeper();
		}
		if (frontIsClear()) {
			move();
		}
		if (frontIsClear()) {
			move();
		}
	}
	
	/**
	 * Karel is allowed to move if the front is clear
	 * @precondition Karel is facing a direction
	 * @postcondition Karel moves one corner
	 */
	private void allowedMovement() {
		if (frontIsClear()) {
			move();
		}
	}
}
