package com.dalphin.engine.desktop.editor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.dalphin.engine.desktop.editor.childpane.MapPane;
import com.dalphin.engine.desktop.editor.componentadapter.MainCA;
import com.dalphin.engine.desktop.editor.menubar.WindowMenuBar;
import com.dalphin.engine.desktop.editor.parentpane.AssetsTabbedPane;
import com.dalphin.engine.desktop.editor.parentpane.GameTabbedPane;

public class MainWindow {
	
	private JFrame frame;
	private AssetsTabbedPane assetTabs;
	private GameTabbedPane gameTabbedPane;
	private WindowMenuBar menuBar;
	private EditorTheme editorTheme;
	boolean exited = false;
	
	/**
	 * 
	 */
	public MainWindow() {
		editorTheme = new EditorTheme(true);
		menuBar = new WindowMenuBar();
		createJFrame();
		gameTabbedPane = new GameTabbedPane();
		assetTabs = new AssetsTabbedPane(frame, gameTabbedPane.getPreviewViewPort().getGame().assetManager);

		finalizeJFrame();
		assetTabs.createBlockPane(gameTabbedPane.getPreviewViewPort().getGame().assetManager);
		assetTabs.createItemPane(gameTabbedPane.getPreviewViewPort().getGame().assetManager);
		assetTabs.setEditorTheme(editorTheme);
		editorTheme.setTheme(false);
		menuBar.createNewWorldButton(gameTabbedPane.getMapEditorPane());
		gameTabbedPane.getMapEditorPane().setBlockPane(assetTabs.getBlockPane());
		gameTabbedPane.getMapEditorPane().setSize(frame.getWidth(), frame.getHeight());
	}
	/**
	 * 
	 */
	public void createJFrame() {
		
		/**
		 * 
		 */
		WindowAdapter listener = new WindowAdapter() {
			/**
			 * 
			 */
			public void windowClosing(WindowEvent evt) {
				Frame frame = (Frame) evt.getSource();
				gameTabbedPane.getPreviewViewPort().getGame().exit = true;
				gameTabbedPane.getPreviewViewPort().getGame().update();
				System.exit(0);
			}

		};
		frame = new JFrame();
		frame.setSize(1280, 720);
		frame.setMinimumSize(new Dimension(480, 270));
		frame.addWindowListener(listener);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void finalizeJFrame() {
		frame.setJMenuBar(menuBar.getMenuBar());
		frame.add(gameTabbedPane.getPane(), BorderLayout.CENTER);
		frame.setVisible(true);
		frame.addComponentListener(new MainCA(gameTabbedPane, assetTabs, frame));
		while (!gameTabbedPane.getPreviewViewPort().getGame().isStarted) {
			System.out.println("Not started");
		}
		frame.add(assetTabs.getTabbedPane(), BorderLayout.WEST);
	}

}
