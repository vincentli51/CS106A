/* 
 * File: SteamTunnelServerTests.java
 * -----------------------
 * This program tests your server by sending a bunch of requests
 * and validating if the response is what it was expecting.
 */

import acm.program.*;
import java.io.*;
import acm.graphics.*;

public class SteamTunnelServerTests extends ConsoleProgram {

	/*****************************************************
	 *        Optional to change: ServerTests            *
	 *               ----------------                    *
	 * Use this class to test your server. Add new tests *
	 * if you want.                                      *
	 *****************************************************/

	/* The internet address of the computer running the server */
	private static final String HOST = "http://localhost:8000/";
	private int passedTests = 0;
	private int totalTests = 0;

	/* Run all of the tests */
	public void run() {

		// a welcome message
		welcomeMessage();

		String[] testNames = {"Chris", "Mehran", "Julie", "Barbra Streisand", "Beyonce Knowles"};
		String[] notAddedNames = {"Voldemort", "Lord Business", "Darth Vader"};

		pingTests();
		addProfileTests(testNames);
		containsProfileTests(testNames, notAddedNames);
		deleteProfileTests();
		statusTests();
		imagesTests();
		friendsTests();
		invalidCommandsTests();

		println("Passed: " + passedTests + "/" + totalTests);
	}

	private void welcomeMessage() {
		println("Running the SteamTunnel server tester");
		println("Make sure that the server has just been restarted");
		println("-------");
		println("");
	}

	private void invalidCommandsTests() {
		println("=== INVALID COMMANDS ===\n");

		// and what if we send a bad command?
		Request bad = new Request("badCommand");
		runTest(bad, true, "");
	}

	private void friendsTests() {
		println("=== FRIENDS ===\n");

		// Chris initially has no friends :(
		Request f1 = new Request("getFriends");
		f1.addParam("name", "Chris");
		runTest(f1, false, "[]");

		// Mehran and Chris become friends!
		Request f2 = new Request("addFriend");
		f2.addParam("name1", "Chris");
		f2.addParam("name2", "Mehran");
		runTest(f2, false, "success");

		// Chris has Mehran as a friend <3
		Request f3 = new Request("getFriends");
		f3.addParam("name", "Chris");
		runTest(f3, false, "[Mehran]");

		// Mehran also has Chris as a friend <3 (reciprocal friendships)
		Request f4 = new Request("getFriends");
		f4.addParam("name", "Mehran");
		runTest(f4, false, "[Chris]");

		// Chris and Julie become friends!
		Request f5 = new Request("addFriend");
		f5.addParam("name1", "Chris");
		f5.addParam("name2", "Julie");
		runTest(f5, false, "success");

		// Error: Chris and Julie are already friends
		Request f5b = new Request("addFriend");
		f5b.addParam("name1", "Chris");
		f5b.addParam("name2", "Julie");
		runTest(f5b, true, "");

		// Chris is now friends with Mehran and Julie
		Request f6 = new Request("getFriends");
		f6.addParam("name", "Chris");
		runTest(f6, false, "[Mehran, Julie]");

		// Deleting Julie's profile should remove her from her friends' friend lists
		Request f7 = new Request("deleteProfile");
		f7.addParam("name", "Julie");
		runTest(f7, false, "success");

		// Chris should now just be friends with Mehran
		Request f8 = new Request("getFriends");
		f8.addParam("name", "Chris");
		runTest(f8, false, "[Mehran]");

		// Error: Chris cannot be friends with nonexistent person
		Request f9 = new Request("addFriend");
		f9.addParam("name1", "Chris");
		f9.addParam("name2", "Voldemort");
		runTest(f9, true, "");

		// Error: Chris cannot be friends with himself
		Request f10 = new Request("addFriend");
		f10.addParam("name1", "Chris");
		f10.addParam("name2", "Chris");
		runTest(f10, true, "");
	}

	private void imagesTests() {
		println("=== IMAGES ===\n");

		// Set and get Chris's image
		GImage image = new GImage("images/ChrisP.jpg");
		String imageString = SimpleServer.imageToString(image);

		Request i1 = new Request("setImage");
		i1.addParam("name", "Chris");
		i1.addParam("imageString", imageString);
		runTest(i1, false, "success");

		Request i2 = new Request("getImage");
		i2.addParam("name", "Chris");
		runTest(i2, false, imageString);

		// Set and get an invalid user's image
		Request i3 = new Request("setImage");
		i3.addParam("name", "Voldemort");
		i3.addParam("imageString", imageString);
		runTest(i3, true, null);

		Request i4 = new Request("getImage");
		i4.addParam("name", "Voldemort");
		runTest(i4, true, null);
	}

	private void statusTests() {
		println("=== STATUS ===\n");

		// Chris's status is empty
		Request s1 = new Request("getStatus");
		s1.addParam("name", "Chris");
		runTest(s1, false, "");

		// Set Chris's status
		Request s2 = new Request("setStatus");
		s2.addParam("name", "Chris");
		s2.addParam("status", "testing");
		runTest(s2, false, "success");

		// Should now get new status back
		Request s3 = new Request("getStatus");
		s3.addParam("name", "Chris");
		runTest(s3, false, "testing");

		// Should get error for unknown user
		Request s4 = new Request("setStatus");
		s4.addParam("name", "Voldemort");
		s4.addParam("status", "evil");
		runTest(s4, true, null);

		// Should get error for unknown user
		Request s5 = new Request("getStatus");
		s5.addParam("name", "Voldemort");
		runTest(s5, true, null);
	}

	private void deleteProfileTests() {
		println("=== DELETE PROFILE ===\n");

		// Should receive error
		Request d1 = new Request("deleteProfile");
		d1.addParam("name", "Voldemort");
		runTest(d1, true, "");

		// Should delete successfully
		Request d2 = new Request("deleteProfile");
		d2.addParam("name", "Beyonce Knowles");
		runTest(d2, false, "success");

		// Should no longer contain profile
		Request d3 = new Request("containsProfile");
		d3.addParam("name", "Beyonce Knowles");
		runTest(d3, false, "false");

		// Should receive error (cannot delete 2x)
		Request d4 = new Request("deleteProfile");
		d4.addParam("name", "Beyonce Knowles");
		runTest(d4, true, "success");

		// Should be able to add again
		Request d5 = new Request("addProfile");
		d5.addParam("name", "Beyonce Knowles");
		runTest(d5, false, "success");
	}

	private void containsProfileTests(String[] testNames, String[] notAddedNames) {
		println("=== CONTAINS PROFILE ===\n");

		// All previously-added profiles should have response "true"
		for (String name : testNames) {
			Request containsRequest = new Request("containsProfile");
			containsRequest.addParam("name", name);
			runTest(containsRequest, false, "true");
		}

		// All un-added profiles should have response "false"
		for (String name : notAddedNames) {
			Request containsRequest = new Request("containsProfile");
			containsRequest.addParam("name", name);
			runTest(containsRequest, false, "false");
		}
	}

	private void addProfileTests(String[] testNames) {
		println("=== ADD PROFILE ===\n");

		// Adding first time should be successful
		for (String name : testNames) {
			Request addRequest = new Request("addProfile");
			addRequest.addParam("name", name);
			runTest(addRequest, false, "success");
		}

		// Adding a second time should give an error
		for (String name : testNames) {
			Request addRequest = new Request("addProfile");
			addRequest.addParam("name", name);
			runTest(addRequest, true, null);
		}
	}

	private void pingTests() {
		println("=== PING ===\n");
		Request ping = new Request("ping");
		runTest(ping, false, "Hello, internet");
	}

	/**
	 * Runs a test and records the response
	 */
	private void runTest(Request request, boolean expectError, String expectedSuccessOutput) {
		println(request.toString());
		boolean success = runServerTest(request, expectError, expectedSuccessOutput);
		totalTests++;
		if(success) {
			passedTests++;
		}
	}

	/**
	 * Runs a request and checks if the result is what was expected (both whether we
	 * expect an error and otherwise what String response is expected)
	 */
	private boolean runServerTest(Request request, boolean expectError, String expectedSuccessOutput) {
		try{
			String result = SimpleClient.makeRequest(HOST, request);
			if(expectError) {
				println("Test failed. Expected an error but didn't get one\n");
				return false;
			} else if(!result.equals(expectedSuccessOutput)) {
				println("Test failed.");
				println("Expected response: " + expectedSuccessOutput);
				println("Actual response:  " + result + "\n");
				return false;
			} else {
				println("Test passed.\n");
				return true;
			}
		} catch(IOException e) {
			if(expectError && e.getMessage().startsWith(SimpleClient.ERROR_KEY)) {
				println("Test passed.\n");
				return true;
			} else {
				println("Test failed. Received unknown error: " + e.getMessage() + "\n");
				return false;
			}
		}
	}
}
