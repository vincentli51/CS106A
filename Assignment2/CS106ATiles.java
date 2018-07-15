/*
 * File: CS106ATiles.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the CS106ATiles problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class CS106ATiles extends GraphicsProgram {
	
	/** Amount of space (in pixels) between tiles */
	private static final int TILE_SPACE = 20;
	private static final int TILE_WIDTH = 100;
	private static final int TILE_HEIGHT = 50;

	public void run() {
		double h = getHeight();
		double w = getWidth();
		double topY = h/2 - TILE_HEIGHT;
		double bottomY = h/2 + TILE_SPACE;
		double leftX = w/2 - TILE_WIDTH - TILE_SPACE/2;
		double rightX = w/2 + TILE_SPACE/2;
	
		GRect rectangle1 = new GRect(leftX, topY, TILE_WIDTH, TILE_HEIGHT);
		GRect rectangle2 = new GRect(rightX, topY, TILE_WIDTH, TILE_HEIGHT);
		GRect rectangle3 = new GRect(leftX, bottomY, TILE_WIDTH, TILE_HEIGHT);		
		GRect rectangle4 = new GRect(rightX, bottomY, TILE_WIDTH, TILE_HEIGHT);
				
		add(rectangle1);	
		add(rectangle2);
		add(rectangle3);
		add(rectangle4);
		
		GLabel label1 = new GLabel("CS106A", leftX + TILE_WIDTH/2 - TILE_SPACE,topY + TILE_HEIGHT/2);
		GLabel label2 = new GLabel("CS106A", rightX + TILE_WIDTH/2 - TILE_SPACE,topY + TILE_HEIGHT/2);
		GLabel label3 = new GLabel("CS106A", leftX + TILE_WIDTH/2 - TILE_SPACE,bottomY + TILE_HEIGHT/2);
		GLabel label4 = new GLabel("CS106A", rightX + TILE_WIDTH/2 - TILE_SPACE,bottomY + TILE_HEIGHT/2);
		
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		
	}
}

