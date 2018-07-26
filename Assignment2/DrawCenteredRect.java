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
import java.awt.event.MouseEvent;

public class DrawCenteredRect extends GraphicsProgram {
	
	/**
	 * Global variables are useful, but potentially dangerous variables to use.
	 * They can help with doing complex operations that need to maintain state across
	 * multiple functions, but when used too liberally, they can add unneeded complexity
	 * that is hard to maintain.
	 */
	double x1, y1; // GLOBAL/CLASS VARIABLE
	GLine rubberBand;
	
	public void run() {
		addMouseListeners();
		
		double x = 0;
		double y = 0;
		int dX = 6;
		int dY = 3;
		GOval oval = new GOval(x, y, 50, 50);
		while (true) {
			add(oval);
			pause(20);
			remove(oval);
			
			// There's a wall at x = 500
			if (x > 500) {
				dX = -dX;
			}
			// There's a wall at x = 0
			if (x < 0) {
				dX = -dX;
			}
			// There's a wall at y = 500
			if (y > 500) {
				dY = -dY;
			}
			// There's a wall at y = 0
			if (y < 0) {
				dY = -dY;
			}
			
			x += dX;
			y += dY;
			oval = new GOval(x, y, 50, 50);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (rubberBand != null) {
			remove(rubberBand);
		}
		rubberBand = new GLine(x1, y1, e.getX(), e.getY());
		add(rubberBand);
	}	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		rubberBand = null;
	}
	
	/** Size of the centered rect */
	/*
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
	*/
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

