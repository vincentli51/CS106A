/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends Karel {
	
	/**
	 * Karel leaves her house to pick up the beeper then re-enters house and places the beeper in the top left corner
	 * @precondition Karel is inside her house in the top left corner facing East
	 * @postcondition Karel places the beeper in the top left corner of her house, facing East  
	 */
	public void run() {
		leaveHouse();
		pickBeeper();
		enterHouse();
		putBeeper();
	}
	
	/**
	 * Karel leaves her house 
	 * @precondition Karel is inside her house in the top left corner facing East
	 * @postcondition Karel is outside her house facing East with the beeper in hand
	 */
	private void leaveHouse() {
		move();
		move();
		turnRight();
		move();
		turnLeft();
		move();
	}
	
	/**
	 * Karel re-enters the house from outside
	 * @precondition Karel is outside her door facing East
	 * @postcondition Karel is in the top left corner of her house, facing East
	 */
	private void enterHouse() {
		turnAround();
		move();
		move();
		move();
		turnRight();
		move();
		turnRight();
	}
	
	/**
	 * Turns Karel around 180 degrees
	 */
	private void turnAround() {
		turnLeft();
		turnLeft();
	}
	
	/**
	 * Turns Karel 90 degrees clockwise
	 */
	private void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
}
