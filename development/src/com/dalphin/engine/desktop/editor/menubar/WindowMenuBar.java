package com.dalphin.engine.desktop.editor.menubar;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.dalphin.engine.desktop.editor.childpane.MapEditorPane;
import com.dalphin.engine.desktop.editor.parentpane.GameTabbedPane;

public class WindowMenuBar {
	
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem exit;
	private JMenuItem newWorld;
	private MapEditorPane mapEditor;
	
	public WindowMenuBar() {
		menuBar = new JMenuBar();
		file = new JMenu("File");
		exit = new JMenuItem("Exit");
		
		
		file.add(exit);
		menuBar.add(file);
	}
	
	public void createNewWorldButton(MapEditorPane mapEditor) {
		newWorld = new JMenuItem("New World");
		newWorld.addActionListener(new NewWorldMenuItem(mapEditor));
		file.add(newWorld);

	}
	
	public JMenuBar getMenuBar() {
		return this.menuBar;
	}
}
