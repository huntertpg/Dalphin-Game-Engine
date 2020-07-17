package com.dalphin.engine.desktop.editor.mapEditor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.dalphin.engine.desktop.editor.EditorBlock;

public class MapAssetPane extends JPanel {

	private MapAssetPane mapPane;
	private JPanel assetPanel;
	public JScrollPane scrollPane;
	private ArrayList<EditorBlock> editorBlocks;
	public ArrayList<MapAsset> mapAssets;
	private int index = 0;
	private MapPane MapAssetPane;
	private Component mapPanel;

	public MapAssetPane(MapPane mapPane) {
		assetPanel = new JPanel();
		assetPanel.setLayout(new GridLayout(index,1));
		scrollPane = new JScrollPane(assetPanel);
		scrollPane.setPreferredSize(new Dimension(200, getHeight()));
		editorBlocks = new ArrayList<EditorBlock>();
		mapAssets = new ArrayList<MapAsset>();
		this.MapAssetPane = mapPane;
		setBackground(Color.BLACK);
		
	}

	public void addBlock(Icon icon, String name, int x, int y) {
		editorBlocks.add(new EditorBlock(icon, name, x, y));
		mapAssets.add(new MapAsset(icon, name, x, y, index));
		assetPanel.add(mapAssets.get(index));
		assetPanel.updateUI();
		index++;
	}

	public void draw(Graphics g) {
		for (int i = 0; i < editorBlocks.size(); i++) {
			if (editorBlocks.size() < 0) {

			} else {
				if (mapPanel != null) {
					editorBlocks.get(i).getIcon().paintIcon(mapPanel, g, editorBlocks.get(i).getX(),
							editorBlocks.get(i).getY());
				}
			}

		}
	}

	/**
	 * @return the mapPanel
	 */
	public Component getMapPanel() {
		return mapPanel;
	}

	/**
	 * @param mapPanel the mapPanel to set
	 */
	public void setMapPanel(Component mapPanel) {
		this.mapPanel = mapPanel;
	}

	class MapAsset extends JPanel {

		private JLabel blockIcon;
		private JLabel blockName;
		private JLabel blockX;
		private JLabel blockY;
		private int index;

		public MapAsset(Icon icon, String name, int x, int y, int index) {
			this.index = index;
			setBackground(Color.LIGHT_GRAY);
			blockIcon = new JLabel(icon);
			blockName = new JLabel("Name: " + name);
			blockX = new JLabel("X: " + Integer.toString(x));
			blockY = new JLabel("Y: " + Integer.toString(y));
			setPreferredSize(new Dimension(150, 60));
			add(blockIcon);
			add(blockName);
			add(blockX);
			add(blockY);
		}
	}

}
