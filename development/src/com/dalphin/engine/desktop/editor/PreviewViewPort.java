package com.dalphin.engine.desktop.editor;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dalphin.engine.LibGDXTestGame;

public class PreviewViewPort {
	
	private LwjglApplicationConfiguration config;
	private ApplicationListener appListener;
	private int width;
	private int height;
	private JPanel panel;
	private LibGDXTestGame game;
	LwjglAWTCanvas canvas;
	
	public PreviewViewPort() {
		config = new LwjglApplicationConfiguration();
		appListener = new LibGDXTestGame();
		create();
	}
	
	public PreviewViewPort(int width, int height) {
		config = new LwjglApplicationConfiguration();
		game = new LibGDXTestGame();
		appListener = game;
		this.width = width;
		this.height = height;
		create();
	}
	
	public PreviewViewPort(LwjglApplicationConfiguration config) {
		appListener = new LibGDXTestGame();
		this.config = config;
		create();
	}
	
	public void create() {
		canvas = new LwjglAWTCanvas(this.appListener);
		canvas.getCanvas().setSize(width, height);
		panel = new JPanel();
		panel.add(canvas.getCanvas(), BorderLayout.CENTER);
	}
	
	public JPanel getPanel() {
		return this.panel;
	}

	/**
	 * @return the config
	 */
	public LwjglApplicationConfiguration getConfig() {
		return config;
	}

	/**
	 * @param config the config to set
	 */
	public void setConfig(LwjglApplicationConfiguration config) {
		this.config = config;
	}

	/**
	 * @return the appListener
	 */
	public ApplicationListener getAppListener() {
		return appListener;
	}

	/**
	 * @param appListener the appListener to set
	 */
	public void setAppListener(ApplicationListener appListener) {
		this.appListener = appListener;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
		canvas.getCanvas().setSize(width, height);
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
		canvas.getCanvas().setSize(width, height);

	}

	/**
	 * @return the game
	 */
	public LibGDXTestGame getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(LibGDXTestGame game) {
		this.game = game;
		canvas.getCanvas().setSize(width, height);

	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * @return the canvas
	 */
	public LwjglAWTCanvas getCanvas() {
		return canvas;
	}

	/**
	 * @param canvas the canvas to set
	 */
	public void setCanvas(LwjglAWTCanvas canvas) {
		this.canvas = canvas;
	}

}
