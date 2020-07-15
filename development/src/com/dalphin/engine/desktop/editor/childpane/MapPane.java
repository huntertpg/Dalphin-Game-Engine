package com.dalphin.engine.desktop.editor.childpane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class MapPane extends JPanel {
	private String mapName;
	private BlockPane blockPane;
	private JToolBar toolBar;
	private JRadioButton gridToggle;
	private MapGraphics mapGraphics;
	private JLabel gridXSize;
	private JLabel gridYSize;
	private JTextField gridXSizeField;
	private JTextField gridYSizeField;

	private int width;
	private int height;

	public MapPane(BlockPane blocks, int width, int height) {
		this.blockPane = blocks;
		this.width = width;
		this.height = height;

		toolBar = new JToolBar();
		gridToggle = new JRadioButton("Grid");
		gridXSize = new JLabel("Size X:");
		gridYSize = new JLabel("Size Y:");
		gridXSizeField = new JTextField(2);
		gridYSizeField = new JTextField(2);

		setBackground(Color.DARK_GRAY);
		setSize(width, height);

		toolBar.setLocation(-100, 0);
		mapGraphics = new MapGraphics();
		mapGraphics.setSize(width, height);

		toolBar.add(gridToggle);
		toolBar.add(gridXSize);
		toolBar.add(gridXSizeField);
		toolBar.add(gridYSize);
		toolBar.add(gridYSizeField);
 
		add(toolBar);
		add(mapGraphics);
		
		gridXSizeField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mapGraphics.repaint();
			}
		});
		
		gridYSizeField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mapGraphics.repaint();
			}
		});

		gridToggle.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {

				if (gridToggle.isSelected()) {
					mapGraphics.drawGrid = true;
					mapGraphics.repaint();
				} else {
					mapGraphics.drawGrid = false;
					mapGraphics.repaint();

				}
			}
		});

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				MapPane.this.width = getWidth();
				MapPane.this.height = getHeight();
			}

			@Override
			public void componentMoved(ComponentEvent e) {

			}
		});
	}

	/**
	 * @return the mapName
	 */
	public String getMapName() {
		return mapName;
	}

	/**
	 * @param mapName the mapName to set
	 */
	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	private class MapGraphics extends JComponent {
		private boolean drawGrid = false;

		public MapGraphics() {

		}

		public void drawGrid(Graphics g) {
			int width;
			int height;

			if (gridYSizeField.getText().contentEquals("")) {
				height = 32;
			} else {
				height = Integer.parseInt(gridYSizeField.getText());
			}
			
			if (gridXSizeField.getText().contentEquals("")) {
				width = 32;
			} else {
				width = Integer.parseInt(gridXSizeField.getText());
			}
			
			for (int i = 0; i < getWidth(); i += width) {
				g.drawLine(i, 0, i, getHeight());
			}
			
			for (int i = 0; i < getHeight(); i += height) {
				g.drawLine(0, i, getWidth(), i);
			}
		}

		@Override
		public void paint(Graphics g) {
			setSize(width, height);
			setLocation(0, 0);
			if (drawGrid) {
				g.setColor(Color.white);
				drawGrid(g);
			} else if (drawGrid == false) {

			}
			// g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.white);
			// blockPane.getButtons().get(0).getIcon().paintIcon(this, g, 0, 0);
			super.paint(g);

		}
	}

}
