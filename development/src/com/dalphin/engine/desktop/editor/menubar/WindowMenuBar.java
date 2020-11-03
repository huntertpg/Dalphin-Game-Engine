package com.dalphin.engine.desktop.editor.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.dalphin.engine.desktop.editor.childpane.MapPane;
import com.dalphin.engine.desktop.editor.mapEditor.MapTabbedPane;
import com.dalphin.engine.desktop.editor.parentpane.GameTabbedPane;

public class WindowMenuBar {

	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem exit;
	private JMenuItem newWorld;
	private JMenuItem previewGame;

	private MapPane mapEditor;
	private GameTabbedPane gameTabbedPane;

	public WindowMenuBar() {
		menuBar = new JMenuBar();
		file = new JMenu("File");
		exit = new JMenuItem("Exit");

		menuBar.add(file);
		file.add(exit);

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

	}

	public void createNewWorldButton(MapTabbedPane mapEditor) {
		file.remove(exit);
		newWorld = new JMenuItem("New World");
		newWorld.addActionListener(new NewWorldMenuItem(mapEditor));
		file.add(newWorld);
		file.add(exit);
	}

	public void previewGameButton(final GameTabbedPane gameTabbedPane) {
		file.remove(exit);
		previewGame = new JMenuItem("Preview Game");
		file.add(previewGame);
		previewGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gameTabbedPane.createGamePreview();
			}
		});
		file.add(exit);
	}

	public JMenuBar getMenuBar() {
		return this.menuBar;
	}

	public void setGameTabbedPane(GameTabbedPane gameTabbedPane) {
		this.gameTabbedPane = gameTabbedPane;
	}
}
