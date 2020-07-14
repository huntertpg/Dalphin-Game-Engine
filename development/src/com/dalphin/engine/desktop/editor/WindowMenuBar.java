package com.dalphin.engine.desktop.editor;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class WindowMenuBar {
	
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem exit;
	
	public WindowMenuBar() {
		menuBar = new JMenuBar();
		file = new JMenu("File");
		exit = new JMenuItem("Exit");
		
		file.add(exit);
		menuBar.add(file);
	}
	
	public JMenuBar getMenuBar() {
		return this.menuBar;
	}

}
