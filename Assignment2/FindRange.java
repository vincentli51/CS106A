/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	
	private static int SENTINEL = 0;
	
	public void run() {
		println("This program finds the largest and smallest numbers");		
		int currentNum = readInt("? ");
		int smallestNum = currentNum;
		int largestNum = currentNum;	
		while (currentNum != SENTINEL) {
			if (currentNum > largestNum) {
				largestNum = currentNum;
			}
			if (currentNum < smallestNum) {
				smallestNum = currentNum;
			}
			currentNum = readInt("? ");
		}
			
				
		println("smallest: " + smallestNum);
		println("largest: " + largestNum);
	}
}

