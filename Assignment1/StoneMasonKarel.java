/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	
	/**
	 * Karel fills the avenues of 1,5,9 and 13.
	 * @precondition Karel is facing East in the bottom left corner of the board
	 * @postcondition Karel is facing East in the bottom right corner of the board
	 */
	public void run() {
		toDo();
		for (int i=0; i < 4;i++) {
			move();	
		}
		toDo();
		for (int i=0; i < 4;i++) {
			move();	
		}
		toDo();
		for (int i=0; i < 4;i++) {
			move();	
		}
		toDo();
	}
		
	 /**
	  * Karel fills the avenue
	  * @precondition Karel is facing East at the bottom of the avenue
	  * @postcondition Karel is still facing East at the bottom of the avenue
	  */
	private void toDo() {
		turnLeft();
		if (frontIsBlocked()) {
			beeperAbsent();
		}
		while (noBeepersPresent()) {
			putBeeper();
		}
		while (frontIsClear()) {
			beeperAbsent();
			move();
		}
		turnAround();
		while (frontIsClear()) {
			beeperAbsent();
			move();
		}
		turnLeft();
	}
	
	 /**
	  *If there are no beeper present in the corner place a beeper
	  *@precondition no beeper 
	  *@postcondition beeper is placed
	  */
	private void beeperAbsent() {
		if (noBeepersPresent()) {
			putBeeper();
		}
	}
}