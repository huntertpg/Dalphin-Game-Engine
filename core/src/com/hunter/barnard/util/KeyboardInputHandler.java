/* Author: Hunter Barnard
 * 
 * This class takes in keyboard input and returns mostly booleans by the buttons pressed
 * this will work in conjunction with the player movement class(yet to be created) to 
 * determain actions and such. This class won't actually do anything except read input and provide
 * that information to other classes
 * 
 */

package com.hunter.barnard.util;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class KeyboardInputHandler extends InputAdapter {
	
	//init variables for checking if movement is true;
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	
	//this method checks to see if a key is down
	@Override
	public boolean keyDown (int keycode) {
	//if W is Up set up to true
	if (keycode == Keys.W) {
		up = true;
	//If S is down set down to true 
	}else if (keycode == Keys.S) {
		down = true;
	//if D is down set right to true
	}else if(keycode == Keys.D) {
		right = true;
	//if A is down set left to true
	}else if(keycode == Keys.A) {
		left = true;
	}
	//else is false
	return false;
	 
	}
	
	//This method is for checking if keys are up. Mainly used for setting move valuse to false
	//due to the key not being pressed anymore
	@Override
	public boolean keyUp (int keycode) {
	if (keycode == Keys.W) {
		up = false;
	}else if (keycode == Keys.S) {
		down = false;
	}else if(keycode == Keys.D) {
		right = false;
	}else if(keycode == Keys.A) {
		left = false;
	}
	return false;
	 
	}
	
	//getters and setters for if keys are down
	public boolean isUp() {
		return up;
	}
	
	public boolean isDown() {
		return down;
	}
	
	public boolean isLeft() {
		return left;
	}
	
	public boolean isRight() {
		return right;
	}
}
