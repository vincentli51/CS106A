/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int startingNum = readInt("Enter a number:");
		int counter = 0;
		while (startingNum != 1) {
			if (startingNum % 2 == 0) {
				println(startingNum + " is even so I take half: " + (startingNum / 2));
				startingNum = startingNum / 2;
			} else {
				println(startingNum + " is odd, so I make 3n + 1: " + (3*startingNum+1));
				startingNum = 3 * startingNum + 1;
			}
			counter = counter + 1;
		}
		println("The process took " + counter + " times to complete.");
	}
}


