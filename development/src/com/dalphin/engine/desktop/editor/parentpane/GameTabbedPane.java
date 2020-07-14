package com.dalphin.engine.desktop.editor.parentpane;


import javax.swing.JTabbedPane;

import com.dalphin.engine.desktop.editor.childpane.PreviewViewPort;
import com.dalphin.engine.desktop.editor.components.DalphinButton;

public class GameTabbedPane {
	
	private JTabbedPane pane;
	private PreviewViewPort gameViewPort;
	private DalphinButton button;
	
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
