/*
 * File: SteamTunnelServer.java
 * ------------------------------
 * When it is finished, this program will implement a basic
 * social network management server.  Remember to update this comment!
 */

import acm.program.*;

public class SteamTunnelServer extends ConsoleProgram 
					implements SimpleServerListener {
	
	/*****************************************************
	 *         TODO: Implement this class                *
	 *****************************************************/
	
	/* The internet port to listen to requests on */
	private static final int PORT = 8000;
	
	/* The server object. All you need to do is start it */
	private SimpleServer server = new SimpleServer(this, PORT);

	public void run() {
		println("Starting server on port " + PORT);
		server.start();
	}

	/**
	 * When a request is sent to this computer, this method is
	 * called. It must return a String.
	 */
	public String requestMade(Request request) {
		String cmd = request.getCommand();
		println(request.toString());
		
		// your code here. 
		
		return "Error: Unknown command " + cmd + ".";
	}

}
