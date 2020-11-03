package com.dalphin.engine.desktop.editor.componentadapter;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import com.dalphin.engine.desktop.editor.parentpane.AssetsTabbedPane;
import com.dalphin.engine.desktop.editor.parentpane.GameTabbedPane;

public class MainCA extends ComponentAdapter{
	
	private GameTabbedPane gameTabbedPane;
	private AssetsTabbedPane assetsPane;
	private JFrame frame;
	
	public MainCA(GameTabbedPane gameTabbedPane, AssetsTabbedPane assetsTabbedPane, JFrame frame) {
		this.gameTabbedPane = gameTabbedPane;
		this.assetsPane = assetsTabbedPane;
		this.frame = frame;
	}
	
    @Override
    public void componentResized(ComponentEvent e) {
      gameTabbedPane.getPane().updateUI();
  	  assetsPane.getTabbedPane().updateUI();
  	  assetsPane.getTabbedPane().setPreferredSize(new Dimension(frame.getWidth() /5, 10000));
  	  gameTabbedPane.getPreviewViewPort().setWidth(gameTabbedPane.getPreviewViewPort().getPanel().getWidth());
  	  gameTabbedPane.getPreviewViewPort().setHeight(gameTabbedPane.getPreviewViewPort().getPanel().getHeight());
    }
    @Override
    public void componentMoved(ComponentEvent e) {
  	  gameTabbedPane.getPane().updateUI();
  	  assetsPane.getTabbedPane().updateUI();
  	  assetsPane.getTabbedPane().setPreferredSize(new Dimension(frame.getWidth() /5, 10000));
  	  gameTabbedPane.getPreviewViewPort().setWidth(gameTabbedPane.getPreviewViewPort().getPanel().getWidth());
  	  gameTabbedPane.getPreviewViewPort().setHeight(gameTabbedPane.getPreviewViewPort().getPanel().getHeight());
	          
    }
}
