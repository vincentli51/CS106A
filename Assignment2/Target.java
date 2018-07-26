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
	
	private static final int BALL_SIZE = 5;
	private static final int BRICK_WIDTH = 30;
	private static final int BRICK_HEIGHT = 10;
	private static final int SLIDER_WIDTH = 60;
	private static final int SLIDER_HEIGHT = 5;
	
	public void run() {
		oneBrick(200, 200);
		movingBall(435, 324);
	}
	
	public void oneBrick(int x, int y) {
		GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		add(brick);
	}
	
	public void movingBall(int x, int y) {
		GOval ball = new GOval(x, y, BALL_SIZE, BALL_SIZE);
		add(ball);
		pause(250);
		ball.move(3, 6);
	}
	
	
}
//	private static final int CIRCLE_RADIUS = 100;
	
	/*
	 * Creates a Target sign.
	 */
	
	
//		double h = getHeight();
//		double w = getWidth();
//		GOval circle1 = new GOval(w/2 - CIRCLE_RADIUS/2, h/2 - CIRCLE_RADIUS/2, CIRCLE_RADIUS, CIRCLE_RADIUS);
//		circle1.setFillColor(Color.RED);
//		circle1.setFilled(true);
//		GOval circle2 = new GOval(w/2 - CIRCLE_RADIUS, h/2 - CIRCLE_RADIUS, CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
//		circle2.setFillColor(Color.WHITE);
//		circle2.setFilled(true);
//		GOval circle3 = new GOval(w/2 -CIRCLE_RADIUS*1.5, h/2 - CIRCLE_RADIUS*1.5, CIRCLE_RADIUS*3, CIRCLE_RADIUS*3);
//		circle3.setFillColor(Color.RED);
//		circle3.setFilled(true);
//		add(circle3);
//		add(circle2);
//		add(circle1);
//	}

