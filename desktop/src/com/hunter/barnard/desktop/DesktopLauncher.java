/* Author: Hunter Barnard
 * This is the main entry point for the Desktop Launcher. This calls the core class
 * once everything has passed
 */
package com.hunter.barnard.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.hunter.barnard.LibGDXTestGame;

public class DesktopLauncher {
	
	//Main method
	public static void main (String[] arg) {
		
		//Create new LWGGL App config and call the Main core game file or rather just start the game
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new LibGDXTestGame(), config);
	}
}
