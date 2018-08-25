/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import javafx.scene.paint.Color;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import com.sun.prism.shader.Solid_TextureFirstPassLCD_AlphaTest_Loader;

public class Breakout extends GraphicsProgram {

	// Dimensions of the canvas, in pixels
	// These should be used when setting up the initial size of the game,
	// but in later calculations you should use getWidth() and getHeight()
	// rather than these constants for accurate size information.
	public static final double CANVAS_WIDTH = 420;
	public static final double CANVAS_HEIGHT = 600;

	// Number of bricks in each row
	public static final int NBRICK_COLUMNS = 10;

	// Number of rows of bricks
	public static final int NBRICK_ROWS = 10;

	// Separation between neighboring bricks, in pixels
	public static final double BRICK_SEP = 4;

	// Width of each brick, in pixels
	public static final double BRICK_WIDTH = Math.floor(
			(CANVAS_WIDTH - (NBRICK_COLUMNS + 1.0) * BRICK_SEP) / NBRICK_COLUMNS);

	// Height of each brick, in pixels
	public static final double BRICK_HEIGHT = 8;

	// Offset of the top brick row from the top, in pixels
	public static final double BRICK_Y_OFFSET = 70;

	// Dimensions of the paddle
	public static final double PADDLE_WIDTH = 60;
	public static final double PADDLE_HEIGHT = 10;

	// Offset of the paddle up from the bottom 
	public static final double PADDLE_Y_OFFSET = 30;

	// Radius of the ball in pixels
	public static final double BALL_RADIUS = 10;

	// The ball's vertical velocity.
	public static final double VELOCITY_Y = 3.0;

	// The ball's minimum and maximum horizontal velocity; the bounds of the
	// initial random velocity that you should choose (randomly +/-).
	public static final double VELOCITY_X_MIN = 1.0;
	public static final double VELOCITY_X_MAX = 3.0;

	// Animation delay or pause time between ball moves (ms)
	public static final double DELAY = 1000.0 / 60.0;

	// Number of turns 
	public static final int NTURNS = 3;
	
	private GRect paddle;
	private GOval ball;
	private GLabel remainLives;
	private GLabel bricksDestroyed;
	private double vX;
	private double vY;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private int bricksHit = 0;

	
	/*
	 * 
	 */
	public void run() {
		// Set the window's title bar text
		setTitle("CS 106A Breakout");

		// Set the canvas size.  In your code, remember to ALWAYS use getWidth()
		// and getHeight() to get the screen dimensions, not these constants!
		setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);

		/* You fill this in, along with any subsidiary methods */
		initScoreChart();
		initBrickRows();
		initPaddle();
		initBall();
		addMouseListeners();
		
		for (int i = NTURNS; i > 0; i--) {
			remainLives.setLabel("Remaining Live: " + i);
			
			waitForClick();
			moveBall();
			if (isGameWon()) {
				break;
			}
			
			remove(ball);
			initBall();
		}
		remove(ball);
		
		if (isGameWon()) {
			GLabel youWin = new GLabel("You Win!!");
			youWin.setCenterX(getWidth() / 2);
			youWin.setCenterY(getHeight() / 2);
			add(youWin);
		} else {
			remainLives.setLabel("Remaining Live: " + 0);
			GLabel youLose = new GLabel("You Lose.");
			youLose.setCenterX(getWidth() / 2);
			youLose.setCenterY(getHeight() / 2);
			add(youLose);
		}
	}
	
	/*
	 * There will be a score board on the center top that has 3 lives and 0 bricks hit. Those numbers will change.
	 */
	private void initScoreChart() {
		double x = getWidth() / 2; 
		
		remainLives = new GLabel("Remaining Live: " + NTURNS);
		remainLives.setCenterX(x);
		remainLives.setCenterY(BRICK_HEIGHT * 2);
		add(remainLives);
		
		bricksDestroyed = new GLabel("Bricks Destroyed: " + bricksHit);
		bricksDestroyed.setCenterX(x);
		bricksDestroyed.setCenterY(BRICK_HEIGHT * 4);
		add(bricksDestroyed);
	}
	
	/*
	 * Check if game is won. When the number of bricks hits is equal to the rows * columns.
	 */
	private boolean isGameWon() {
		if (bricksHit == NBRICK_COLUMNS * NBRICK_ROWS) {
			return true;
		}
		
		return false;
	}
	
	/*
	 * The ball moves. When it collides with an object or the walls the ball turns around and continue to move.
	 * If the bottom x axis is hit, then a life is lost. If a brick is hit the brick hit count increases.
	 */
	private void moveBall() {
		while (true) {
			ball.move(vX, vY);
			pause(10);
			if (ball.getX() < 0 || getWidth() - BALL_RADIUS * 2 < ball.getX()) {
				vX *= -1;
			}
			if (ball.getY() < 0 || getHeight() - BALL_RADIUS * 2 < ball.getY()) {
				vY *= -1;	
			}
			GObject collided = detectCollision();
			if (collided != null) {
				vY *= -1;
				
				if (collided == paddle) {
					vY = -Math.abs(vY);
				}
			}
			if (collided != paddle && collided != null) {
				bricksHit++;
				bricksDestroyed.setLabel("Bricks Destroyed: " + bricksHit);
				remove(collided);
			}
			if (getHeight() - BALL_RADIUS * 2 < ball.getY()) {
				break;
			}
			if (isGameWon()) {
				break;
			}
		}
	}
	
	/*
	 * Checks if any side of the ball made contact with an object or wall.
	 */
	private GObject detectCollision() {
		GObject e1 = getElementAt(ball.getX(), ball.getY());
		if (e1 != null) {
			return e1;
		}
		GObject e2 = getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY());
		if (e2 != null) {
			return e2;
		}
		GObject e3 = getElementAt(ball.getX(), ball.getY() + BALL_RADIUS * 2);
		if (e3 != null) {
			return e3;
		}
		GObject e4 = getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY() + BALL_RADIUS * 2);
		if (e4 != null) {
			return e4;
		}
		return null;
	}
	
	/*
	 * The paddle is put on screen.
	 */
	private void initPaddle() {
		paddle = new GRect(getWidth() / 2, getHeight() - PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle);
	}

	/*
	 * The ball is put on screen. The ball has a set y rate, but x rate is random. 
	 */
	private void initBall() {
		ball = new GOval(getWidth()/2 - BALL_RADIUS, getHeight()/2 - BALL_RADIUS, BALL_RADIUS * 2, BALL_RADIUS * 2);
		vY = VELOCITY_Y;
		vX = rgen.nextDouble(VELOCITY_X_MIN, VELOCITY_X_MAX);
		if (rgen.nextBoolean()) {
			vX = -vX;
		}
		ball.setFilled(true);
		add(ball);
	}
	
	/*
	 * The bricks is put into places. Color of the brick depends on the remainders of any number divided by 10.
	 * 1-2 is red.
	 * 3-4 is orange.
	 * 5-6 is yellow.
	 * 7-8 is green.
	 * 9-0 is cyan.
	 * Pattern continues.
	 */
	private void initBrickRows() {
		double startX = BRICK_SEP * 1.5;
		double startY = BRICK_Y_OFFSET;
		for (int r = 0; r < NBRICK_ROWS; r++) {
			for(int c = 0; c < NBRICK_COLUMNS; c++) {
				GRect oneBrick = new GRect(startX + (BRICK_WIDTH + BRICK_SEP) * c, startY + (BRICK_HEIGHT + BRICK_SEP/2) * r, 
						BRICK_WIDTH, BRICK_HEIGHT);
				int lastDigit = r % 10;
				if (lastDigit == 0 || lastDigit == 1) {
					oneBrick.setFillColor(java.awt.Color.RED);
				} else if (lastDigit == 2 || lastDigit == 3) {
					oneBrick.setFillColor(java.awt.Color.ORANGE);
				} else if (lastDigit == 4 || lastDigit == 5) {
					oneBrick.setFillColor(java.awt.Color.YELLOW);
				} else if (lastDigit == 6 || lastDigit == 7) {
					oneBrick.setFillColor(java.awt.Color.GREEN);
				} else if (lastDigit == 8 || lastDigit == 9) {
					oneBrick.setFillColor(java.awt.Color.CYAN);
				}
				oneBrick.setFilled(true);
				add(oneBrick);
			}
		}
	}
	
	/*
	 * Checks if the mouse is moving. Changes the x value of the paddle.
	 */
	public void mouseMoved(MouseEvent event) {
		double x = event.getX();
		if (PADDLE_WIDTH/2 < x && x < getWidth() - PADDLE_WIDTH/2) {
			paddle.setX(x - PADDLE_WIDTH/2);
		}
	}
}




