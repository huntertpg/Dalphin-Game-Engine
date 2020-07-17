package com.dalphin.engine.desktop.editor.mapEditor;

import javax.swing.JTabbedPane;

import com.dalphin.engine.desktop.editor.childpane.BlockPane;

public class MapTabbedPane extends JTabbedPane{
	
	private BlockPane blockPane;
	
	public void addMap(String mapName) {
		addTab(mapName, new MapPane(blockPane));
	}
	
	public void setBlockPane(BlockPane blockPane) {
		this.blockPane = blockPane;
	}
	
}
