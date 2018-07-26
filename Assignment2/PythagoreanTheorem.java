/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	
	public void run() {
		println("Enter values to compute the Pythagorean theorem.");
		while (true) {
			double a = readDouble("a: ");
			double b = readDouble("b: ");
			a = Math.pow(a, 2);
			b = 	Math.pow(b, 2);
			double c = Math.sqrt(a + b);
			println("c = " + c);
		}
	}
}
