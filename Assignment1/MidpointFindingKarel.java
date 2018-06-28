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
	
//	
//	public void run() {
//		for (int i = 10; i >= 0; i--) {
//			while (frontIsClear()) {
//				move();
//			}
//			turnAround();
//		}
//	}
//}
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (frontIsClear()) {
				move();
			}
		}
		turnAround();
		for (int i = 0; i < 9; i++) {
			if (frontIsClear()) {
				move();
			}
		}
		turnAround();
		for (int i = 0; i < 8; i++) {
			if (frontIsClear()) {
				move();
			}
		}
		turnAround();
		for (int i = 0; i < 7; i++) {
			if (frontIsClear()) {
				move();
			}
		}
		turnAround();
		for (int i = 0; i < 6; i++) {
			if (frontIsClear()) {
				move();
			}
		}
		turnAround();
		for (int i = 0; i < 5; i++) {
			if (frontIsClear()) {
				move();
			}
		}
		turnAround();
		for (int i = 0; i < 4; i++) {
			if (frontIsClear()) {
				move();
			}
		}
		turnAround();
		for (int i = 0; i < 3; i++) {
			if (frontIsClear()) {
				move();
			}
		}
		turnAround();
		for (int i = 0; i < 2; i++) {
			if (frontIsClear()) {
				move();
			}
		}
		turnAround();
		for (int i = 0; i < 1; i++) {
			if (frontIsClear()) {
				move();
			}
		}
		putBeeper();
	}
}
	
	
	
