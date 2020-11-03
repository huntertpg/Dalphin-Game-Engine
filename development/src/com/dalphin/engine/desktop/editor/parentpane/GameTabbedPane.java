package com.dalphin.engine.desktop.editor.parentpane;


import javax.swing.JTabbedPane;

import com.dalphin.engine.desktop.editor.childpane.MapPane;
import com.dalphin.engine.desktop.editor.childpane.PreviewViewPort;
import com.dalphin.engine.desktop.editor.components.DalphinButton;
import com.dalphin.engine.desktop.editor.mapEditor.MapAssetPane;
import com.dalphin.engine.desktop.editor.mapEditor.MapTabbedPane;

public class GameTabbedPane {
	
	private JTabbedPane pane;
	private PreviewViewPort gameViewPort;
	private DalphinButton button;
	private MapTabbedPane mapEditor;
	
	public GameTabbedPane() {
		pane = new JTabbedPane();
		gameViewPort = new PreviewViewPort(640, 480);
		mapEditor = new MapTabbedPane();
		pane.addTab("Game Preview",gameViewPort.getPanel());
		pane.addTab("Map Editor", mapEditor);
	}
	
	public PreviewViewPort getPreviewViewPort() {
		return gameViewPort;
	}
	
	public JTabbedPane getPane() {
		return this.pane;
	}
	
	public MapTabbedPane getMapEditorPane() {
		return this.mapEditor;
	}
	
	public void createGamePreview() {
		gameViewPort = new PreviewViewPort(640, 480);
		pane.addTab("Game Preview",gameViewPort.getPanel());
	}
	
	
}
