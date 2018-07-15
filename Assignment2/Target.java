/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;



public class Target extends GraphicsProgram {
	
	private static final int CIRCLE_RADIUS = 100;
	
	public void run() {
		double h = getHeight();
		double w = getWidth();
		GOval circle1 = new GOval(w/2 - CIRCLE_RADIUS/2, h/2 - CIRCLE_RADIUS/2, CIRCLE_RADIUS, CIRCLE_RADIUS);
		circle1.setFillColor(Color.RED);
		circle1.setFilled(true);
		GOval circle2 = new GOval(w/2 - CIRCLE_RADIUS, h/2 - CIRCLE_RADIUS, CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
		circle2.setFillColor(Color.WHITE);
		circle2.setFilled(true);
		GOval circle3 = new GOval(w/2 -CIRCLE_RADIUS*1.5, h/2 - CIRCLE_RADIUS*1.5, CIRCLE_RADIUS*3, CIRCLE_RADIUS*3);
		circle3.setFillColor(Color.RED);
		circle3.setFilled(true);
		add(circle3);
		add(circle2);
		add(circle1);
	}
}
