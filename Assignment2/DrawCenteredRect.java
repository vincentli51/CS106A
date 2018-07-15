/*
 * File: DrawCenteredRect.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the DrawCenteredRect problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class DrawCenteredRect extends GraphicsProgram {
	
	/** Size of the centered rect */
	private static final int WIDTH = 350;
	private static final int HEIGHT = 270;

	public void run() {
		double h = getHeight();
		double w = getWidth();
		GRect rectangle = new GRect(w/2 - WIDTH/2, h/2 - HEIGHT/2, WIDTH, HEIGHT);
		rectangle.setFillColor(Color.BLUE);
		rectangle.setFilled(true);
		add(rectangle);
	}
	 
	/*
		private static final int HEAD_WIDTH = 200;
		private static final int HEAD_HEIGHT = 400;
		private static final int MOUTH_WIDTH = 150;
		private static final int MOUTH_HEIGHT = 50;
		private static final int EYE_RADIUS = 25;
		
		double h = getHeight();
		double w = getWidth();	
		double headX = w/2 - HEAD_WIDTH/2;
		double headY = h/2 - HEAD_HEIGHT/2;
		GRect head = new GRect(headX, headY, HEAD_WIDTH, HEAD_HEIGHT);
		head.setFillColor(Color.DARK_GRAY);
		head.setFilled(true);
		GOval eye1 = new GOval(headX + HEAD_WIDTH/4 - EYE_RADIUS, headY + HEAD_HEIGHT/4 - EYE_RADIUS, EYE_RADIUS*2, EYE_RADIUS*2);
		eye1.setFillColor(Color.YELLOW);
		eye1.setFilled(true);
		eye1.pause(400);
		GOval eye2 = new GOval(w/2 + HEAD_WIDTH/4 - EYE_RADIUS, h/2 - HEAD_HEIGHT/4 - EYE_RADIUS, EYE_RADIUS*2, EYE_RADIUS*2);
		eye2.setFilled(true);
		eye2.setFillColor(Color.YELLOW);
		eye2.pause(400);
		GRect mouth = new GRect(w/2 - MOUTH_WIDTH/2, h/2 + HEAD_HEIGHT/4 - MOUTH_HEIGHT/2, MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setFillColor(Color.WHITE);
		mouth.setFilled(true);
		add(head);
		add(eye1);
		add(eye2);
		add(mouth);
	/*
	    double h = getHeight();
		double w = getWidth();	
		GLabel text = new GLabel("CS106A rocks my socks!");
		text.setCenterX(w/2);
		text.setCenterY(h/2);
		add(text);
		
		double labelWidth = text.getWidth();
		double labelHeight = text.getAscent() + 10;
		GRect perimeter = new GRect(w/2 - labelWidth/2 , h/2 - labelHeight/2, labelWidth, labelHeight);
		
		add(perimeter);
	 */
}

