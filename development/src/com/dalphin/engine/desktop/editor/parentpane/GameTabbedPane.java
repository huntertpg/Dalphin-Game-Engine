package com.dalphin.engine.desktop.editor.parentpane;


import javax.swing.JTabbedPane;

import com.dalphin.engine.desktop.editor.childpane.MapEditorPane;
import com.dalphin.engine.desktop.editor.childpane.PreviewViewPort;
import com.dalphin.engine.desktop.editor.components.DalphinButton;

public class GameTabbedPane {
	
	private JTabbedPane pane;
	private PreviewViewPort gameViewPort;
	private DalphinButton button;
	private MapEditorPane mapEditor;
	
	public GameTabbedPane() {
		pane = new JTabbedPane();
		gameViewPort = new PreviewViewPort(640, 480);
		mapEditor = new MapEditorPane();
		pane.addTab("Game Preview",gameViewPort.getPanel());
		pane.addTab("Map Editor", mapEditor.getPane());
	}
	
	public PreviewViewPort getPreviewViewPort() {
		return gameViewPort;
	}
	
	public JTabbedPane getPane() {
		return this.pane;
	}
	
	public MapEditorPane getMapEditorPane() {
		return this.mapEditor;
	}
	
	
}
