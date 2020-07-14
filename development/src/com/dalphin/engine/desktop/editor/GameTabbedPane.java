package com.dalphin.engine.desktop.editor;

import javax.swing.JTabbedPane;

public class GameTabbedPane {
	
	private JTabbedPane pane;
	private PreviewViewPort gameViewPort;
	
	public GameTabbedPane() {
		pane = new JTabbedPane();
		gameViewPort = new PreviewViewPort(640, 480);
		
		pane.addTab("Game Preview",gameViewPort.getPanel());
	}
	
	public PreviewViewPort getPreviewViewPort() {
		return gameViewPort;
	}
	
	public JTabbedPane getPane() {
		return this.pane;
	}
	
	
}
