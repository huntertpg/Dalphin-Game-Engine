package com.dalphin.engine.desktop.editor.parentpane;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.dalphin.engine.desktop.editor.EditorTheme;
import com.dalphin.engine.desktop.editor.childpane.BlockPane;
import com.dalphin.engine.desktop.editor.childpane.ItemPane;
import com.dalphin.engine.managers.AssetManager;

public class AssetsTabbedPane {
	private JTabbedPane assetTabs;
	private BlockPane blockPane;
	private ItemPane itemPane;
	private AssetManager assetManager;
	private EditorTheme editorTheme;
	
	public AssetsTabbedPane(JFrame frame, AssetManager assetManager) {
		this.assetManager = assetManager;
		assetTabs = new JTabbedPane();
		assetTabs.setPreferredSize(new Dimension(frame.getWidth() /5, 10000));
	}
	
	public JTabbedPane getTabbedPane() {
		return this.assetTabs;
	}
	
	public void createBlockPane(AssetManager assetManager) {
		blockPane = new BlockPane(assetManager);
		if(editorTheme != null) {
			blockPane.setEditorTheme(editorTheme);
		}
		assetTabs.addTab("Blocks", blockPane.getPanel());
	}
	
	public void createItemPane(AssetManager assetManager) {
		itemPane = new ItemPane(assetManager);
		if(editorTheme != null) {
			itemPane.setEditorTheme(editorTheme);
		}
		assetTabs.addTab("Items", itemPane.getPanel());
	}
	
	public BlockPane getBlockPane() {
		return this.blockPane;
	}
	
	public void setEditorTheme(EditorTheme editorTheme) {
		this.editorTheme = editorTheme;
		if(blockPane != null) {
			blockPane.setEditorTheme(editorTheme);
		}
		if(itemPane != null) {
			itemPane.setEditorTheme(editorTheme);
		}
		
	}

}
