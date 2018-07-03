
import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	
	/**
	 * Karel fills the avenues of 1,5,9 and 13.
	 * @precondition Karel is facing East in the bottom left corner of the board
	 * @postcondition Karel is facing East in the bottom right corner of the board
	 */
	public void run() {
		repairAvenue();
		while (frontIsClear()) {
			for (int i = 0; i < 4; i++) {
				move();	
			}
			repairAvenue();
		}		
		
	}
		
	 /**
	  *	Karel puts fills the avenue with beepers
	  * @precondition Karel is facing East at the bottom of the avenue
	  * @postcondition Karel is still facing East at the bottom of the avenue
	  */
	private void repairAvenue() {
		turnLeft();
		if (frontIsBlocked()) {
			safePutBeeper();
		}
		while (noBeepersPresent()) {
			putBeeper();
		}
		while (frontIsClear()) {
			safePutBeeper();
			move();
		}
		turnAround();
		while (frontIsClear()) {
			safePutBeeper();
			move();
		}
		turnLeft();
	}
	
	 /**
	  * If there are no beeper present in the corner place a beeper
	  * @precondition no beeper 
	  * @postcondition beeper is placed
	  */
	
	private void safePutBeeper() {
		if (noBeepersPresent()) {
			putBeeper();
		}
	}	
	
}	
	