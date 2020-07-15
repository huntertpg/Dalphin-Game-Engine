package com.dalphin.engine.desktop.editor.childpane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

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

	private JRadioButton gridSnap;

	private MapGraphics mapGraphics;

	private JLabel gridXSize;
	private JLabel gridYSize;

	private JLabel gridXSnap;
	private JLabel gridYSnap;

	private JTextField gridXSizeField;
	private JTextField gridYSizeField;

	private JTextField gridXSnapField;
	private JTextField gridYSnapField;

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

		gridSnap = new JRadioButton("Grid Snap");
		gridXSnap = new JLabel("Snap X:");
		gridYSnap = new JLabel("Snap Y:");
		gridXSnapField = new JTextField(2);
		gridYSnapField = new JTextField(2);
		gridXSnapField.setEnabled(false);
		gridYSnapField.setEnabled(false);

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

		toolBar.add(gridSnap);
		toolBar.add(gridXSnap);
		toolBar.add(gridXSnapField);
		toolBar.add(gridYSnap);
		toolBar.add(gridYSnapField);
		
		toolBar.setFloatable(false);
		
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

		gridSnap.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {

				if (gridSnap.isSelected()) {
					gridXSnapField.setEnabled(true);
					gridYSnapField.setEnabled(true);
					mapGraphics.snapToGrid = true;
					mapGraphics.repaint();
				} else {
					gridXSnapField.setEnabled(false);
					gridYSnapField.setEnabled(false);
					mapGraphics.snapToGrid = false;
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
		private boolean snapToGrid = false;
		int mouseX;
		int mouseY;
		int blockX;
		int blockY;

		public MapGraphics() {
			addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseMoved(MouseEvent e) {
					// TODO Auto-generated method stub
					mouseX = e.getX();
					System.out.println("Mouse X " + mouseX);
					mouseY = e.getY();
					repaint();
				}

				@Override
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});
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

		public void snapToGrid(Graphics g) {
			
			int width;
			int height;
			
			if (gridYSnapField.getText().contentEquals("")) {
				height = 32;
			} else {
				height = Integer.parseInt(gridYSnapField.getText());
			}

			if (gridXSnapField.getText().contentEquals("")) {
				width = 32;
			} else {
				width = Integer.parseInt(gridXSnapField.getText());
			}

			
			blockX = ((mouseX + width / 2) / width) * width;
			blockY = ((mouseY + height / 2 ) / height) * height;
			blockPane.getButtons().get(2).getIcon().paintIcon(this, g, blockX, blockY);
		}

		@Override
		public void paint(Graphics g) {
			setSize(width, height);
			setLocation(0, 0);
			if (drawGrid) {
				g.setColor(new Color(184, 184, 184));
				drawGrid(g);
			}
			
			if (snapToGrid) {
				snapToGrid(g);
			}else {
				blockPane.getButtons().get(2).getIcon().paintIcon(this, g, mouseX, mouseY);

			}
			// g.fillRect(0, 0, getWidth(), getHeight());

			System.out.println("Block X: " + blockX);
			super.paint(g);

		}
	}

}
