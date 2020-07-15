package com.dalphin.engine.desktop.editor.childpane;

import javax.swing.JTabbedPane;

public class MapEditorPane {
	
	private JTabbedPane maps;
	private BlockPane blocks;
	/**
	 * 
	 */
	public MapEditorPane() {
		maps = new JTabbedPane();
		
	}
	/**
	 * 
	 * @return
	 */
	public JTabbedPane getPane() {
		return this.maps;
	}
	/**
	 * 
	 * @param blocks
	 */
	public void setBlockPane(BlockPane blocks) {
		this.blocks = blocks;
	}
	/**
	 * 
	 * @return
	 */
	public BlockPane getBlocks() {
		return this.blocks;
	}
	
	public void setSize(int width, int height) {
		this.maps.setSize(width, height);
	}
	

}
