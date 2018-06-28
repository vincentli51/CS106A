/* 
 * File: SteamTunnelClient.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management client.  Remember to update this comment!
 */

import acm.graphics.*;
import acm.program.*;
import java.io.*;

public class SteamTunnelClient extends GraphicsProgram {
	
	/**********************************************************
	 *                  Optional: Client                      *
	 *                  ----------------                      *
	 * If you finish the server early you can optionally      *
	 * write the client yourself.                             *
	 **********************************************************/

	/** Number of characters for each of the text input fields */
	public static final int TEXT_FIELD_SIZE = 15;

	/** Name of font used to display the application message at the
	 *  bottom of the display canvas */
	public static final String MESSAGE_FONT = "Dialog-18";

	/** Name of font used to display the name in a user's profile */
	public static final String PROFILE_NAME_FONT = "Dialog-24";

	/** The number of pixels in the vertical margin between the bottom 
	 *  of the canvas display area and the baseline for the message 
	 *  text that appears near the bottom of the display */
	public static final double BOTTOM_MESSAGE_MARGIN = 20;

	/** The number of pixels in the hortizontal margin between the 
	 *  left side of the canvas display area and the Name, Image, and 
	 *  Status components that are display in the profile */	
	public static final double LEFT_MARGIN = 20;	

	/** The number of pixels in the vertical margin between the top 
	 *  of the canvas display area and the top (NOT the baseline) of 
	 *  the Name component that is displayed in the profile */	
	public static final double TOP_MARGIN = 20;	

	/** The address of the server that should be contacted when sending
	 * any Requests. */
	private static final String HOST = "http://localhost:8000/";

	/** 
	 * Init is called before the window is created 
	 */
	public void init() {
		// your code here
	}
	
	/** 
	 * Run is called after the window is created 
	 */
	public void run() {
		pingTheServer(); // your code here
	}

	/**
	 * This method is an example of sending a request to the server.
	 * You can delete it when you are ready.
	 */
	private void pingTheServer() {
		try {
			// Lets prepare ourselves a new request with command "ping".
			Request example = new Request("ping");
			// We are ready to send our request
			String result = SimpleClient.makeRequest(HOST, example);
			drawCenteredLabel(result);
		} catch (IOException e) {
			drawCenteredLabel(e.getMessage());
		}
	}

	/**
	 * Again, this is a helper method that we wrote for the "pingTheServer"
	 * example (above). You should not include it in your final submission.
	 */
	private void drawCenteredLabel(String text) {
		GLabel label = new GLabel(text);
		label.setFont("courier-24");
		double x = (getWidth() - label.getWidth())/2;
		double y = (getHeight() - label.getAscent())/2;
		add(label, x, y);
	}
}
