/*
 * File: Countdown.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the Countdown problem.
 */

import acm.program.*;

public class Countdown extends ConsoleProgram {
	
	/** Count down to 0 from this number */
	private static final int START = 10;
	
	public void run() {

	}
	
	/*
	private static final int MAXIMUM_VALUE = 56875;
	private static final int STARTING_FIB_NUM = 3;
	
	public void run() {
		println("This program lists the fibonacci sequence.");
		int fibCounter = 1;
		while (true) {
			int currFibNum = fib(fibCounter);
			
			if (currFibNum > MAXIMUM_VALUE) {
				break;
			}
			
			println(currFibNum);
			fibCounter++;
		}
	}
	
	private int fib(int n) {	
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		
		int prevPrevVal = 0;
		int prevVal = 1;
		int curr = prevVal + prevPrevVal;
		
		for (int i = 0; i < n - STARTING_FIB_NUM; i++) {
			prevPrevVal = prevVal;
			prevVal = curr;
			curr = prevVal + prevPrevVal; 
		}
		
		return curr;
	}
	*/


	/*
	public void run() {
		double x = areaOfTriangle(8, 3);
		println("Area of triangle is " + x);
		double y = areaOfRectangle(7, 9);
		println("Area of Rectangle is " + y);
		double a = salesTax(10, 0.08875);
		println("Sales tax of $10 in New York is " + a);
	}
		double b = salesTax(10, .0625);
		println("Sales tax of $10 in Massachusetts is " + b);
	}
	
	private double areaOfTriangle(double base, double height) {
		double area = .5 * base * height;
		return area;
	}
	
	private double areaOfRectangle(double base, double height) {
		double area = base * height;
		return area;
	private double salesTax(double subtotal, double taxRate) {
		double salesTax = subtotal * taxRate;
		return salesTax;
	}
	*/
}

