package com.dalphin.engine.desktop.editor;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.dalphin.engine.LibGDXTestGame;
import com.dalphin.engine.managers.AssetManager;

public class MainWindow {
	LibGDXTestGame game;
	JFrame frame;
	JTabbedPane left; 
	PreviewViewPort gameViewPort;
	AssetManager test;
	public MainWindow() {

		JTabbedPane middle = new JTabbedPane();
		left = new JTabbedPane();
		frame = new JFrame();
		game = new LibGDXTestGame();


		frame.add(left, BorderLayout.WEST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(1280, 720);
		gameViewPort = new PreviewViewPort(640, 480);
		gameViewPort.setWidth(1280);
		gameViewPort.setHeight(720);
		middle.addTab("Game Preview", gameViewPort.getPanel());
		frame.add(middle, BorderLayout.CENTER);
		while(!gameViewPort.getGame().isStarted) {
			System.out.println("Not started");
		}
		addPanes();
	}
	
	
	public void addPanes() {
		BlockPane blockPane = new BlockPane(gameViewPort.getGame().assetManager);
		left.add(blockPane.getPanel());
	}
	
}
