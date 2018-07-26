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
		int currentNum = readInt("Enter a number:");
		int counter = 0;
		while (currentNum != 1) {
			if (currentNum % 2 == 0) {
				println(currentNum + " is even so I take half: " + (currentNum / 2));
				currentNum = currentNum / 2;
			} else {
				println(currentNum + " is odd, so I make 3n + 1: " + (3*currentNum+1));
				currentNum = 3 * currentNum + 1;
			}
			counter = counter + 1;
		}
		println("The process took " + counter + " times to complete.");
	}
}


