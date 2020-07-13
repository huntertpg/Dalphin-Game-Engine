/* Author: Hunter Barnard
 * This is the main entry point for the Desktop Launcher. This calls the core class
 * once everything has passed
 */
package com.dalphin.engine.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dalphin.engine.LibGDXTestGame;

public class DesktopLauncher {
	
	//Main method
	public static void main (String[] arg) {
		
		//Create new LWGGL App config and call the Main core game file or rather just start the game
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 720;
		config.width = 1280;
		new LwjglApplication(new LibGDXTestGame(), config);
	}
}
