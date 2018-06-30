/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
	
	/**
	 * Karel moves in a line between boundaries to find the midpoint
	 * @precondition Karel is facing East on the bottom left corner
	 * @postcondition Karel is on the Midpoint facing East 
	 */
	public void run() {
		while (noBeepersPresent()) {
			moveToEnd();
			shrinkBoundary();
			safeMove();
		}
		turnAround();
		pickBeeper();
		safeMove();
		if (noBeepersPresent()) {
			putBeeper();
		}
	}
	
	/**
	 * If the statement is true, Karel moves one in the direction its facing
	 * @precondition Karel is facing a direction
	 * @postcondition Karel either moves one in the direction its facing or stays put. 
	 */
	private void safeMove() {
		if (frontIsClear()) {
			move();
		}
	}
	
	/**
	 * If the statement is true, Karel moves from one boundary to the other
	 * @precondition Karel is on a boundary facing the other boundary
	 * @postcondition Karel moves to the other boundary still facing the boundary
	 */
	private void moveToEnd() {
		while (frontIsClear() && noBeepersPresent()) {
			move();
		}
	}

	/**
	 * Karel is on a boundary. It turns around. If statement is true Karel places a beeper, 
	 * if not Karel moves one in the direction its facing and if the second statement is true, 
	 * Karel places a beeper, if it is not true then Karel does nothing 
	 * @precondition Karel is on a boundary facing the wall boundary
	 * @postcondition Karel is one the corner before the boundary it was just on
	 */
	private void shrinkBoundary() {
		turnAround();
		if (noBeepersPresent()) {
			putBeeper();
		} else {
			pickBeeper();
			move();
			if (noBeepersPresent()) {
				putBeeper();
			}
		}
	}
}