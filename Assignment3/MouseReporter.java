/*
 * File: MouseReporter.java
 * -----------------------------
 * Output the location of the mouse to a label on the
 * screen. Change the color of the label to red when
 * the mouse touches it.
 */

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.*;

public class MouseReporter extends GraphicsProgram {

	// A constant for the x value of the label
	private static final int INDENT = 20;
	
	// This variable is visible to the entire program
	// It is called an "instance" variable
	private GLabel label = new GLabel("");
	
	public void run() {	
		GRect rect = new GRect(100, 100, 100, 100);
		rect.setFillColor(Color.BLUE);
		rect.setFilled(true);
		add(rect);
		
		// this code already adds the label to the screen!
		// run it to see what it does.
		label.setFont("Courier-24");
		label.setColor(Color.BLUE);
		
		// this setLabel method takes in a "String" 
		// you can concatenate integers and commas as such:
		label.setLabel(0 + "," + 0);
		
		// add the label to the screen!
		add(label, INDENT, getHeight()/2);

		addMouseListeners();
		
		int incremented = addOne(1);
		println(incremented);
		//listenForMouseEvents();
	}
	
	private int addOne(int num) {
		return num + 1;
	}
	
	/*
	private void listenForMouseEvents() {
		while (true) {
			MouseEvent event = getMouseEvent();
			if (event.getID() == MouseEvent.COMPONENT_MOVED) {
				mouseMoved(event);
			} else if (event.getID() == MouseEvent.MOUSE_CLICKED) {
				mouseClicked(event);
			}
			..
			..
			..
		}
	}
	*/
	
	
	public void mouseMoved(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		label.setLabel(x + "," + y);
		GObject obj = getElementAt(x, y);
		if (obj != null && obj == label) {
			label.setColor(Color.RED);
		} else {
			label.setColor(Color.BLUE);
		}
	}
	
	public void mouseClicked(MouseEvent event) {
		label.setLabel(10 + "," + 10);
	}

}
