/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 50;

/** Height of each brick in pixels */
	private static final int BRICK_HEIGHT = 30;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 12;
	
	public void run() {
		double h = getHeight();
		double w = getWidth();
		
		double startX = w / 2 - BRICK_WIDTH * BRICKS_IN_BASE / 2;
		double startY = h - BRICK_HEIGHT;
		
		for (int j = 0; j < BRICKS_IN_BASE; j++) {
			layDownRow(startX, startY, BRICKS_IN_BASE - j);
			startX = startX + BRICK_WIDTH / 2;
			startY = startY - BRICK_HEIGHT;  
		}
	}
	
	/*
	 * Fills a row with a specific amount of bricks.
	 */
	private void layDownRow(double x, double y, int brickNum) {
		for (int i = 0; i < brickNum; i++) {
			GRect rectangle = new GRect(x + (i * BRICK_WIDTH), y, BRICK_WIDTH, BRICK_HEIGHT);
			add(rectangle);
		}
	}
}

