package com.dalphin.engine.desktop.editor.mapEditor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.badlogic.gdx.utils.Collections;
import com.dalphin.engine.desktop.editor.childpane.BlockPane;

public class MapPane extends JPanel {

	private MapCanvas mapCanvas;
	private JToolBar toolBar;
	private JRadioButton drawGrid;
	private JRadioButton snapToGrid;
	private JTextField gridX;
	private JTextField gridY;
	private JTextField gridSnapX;
	private JTextField gridSnapY;
	private MapAssetPane mapAssets;

	private boolean doDrawGrid;
	private boolean doSnapToGrid;
	
	private int gridXValue = 32;
	private int gridYValue = 32;

	private int gridSnapXValue = 32;
	private int gridSnapYValue = 32;

	public MapPane(final BlockPane blockPane) {
		setLayout(new BorderLayout());
		toolBar = new JToolBar();
		mapAssets = new MapAssetPane(this);
		drawGrid = new JRadioButton("Grid");
		snapToGrid = new JRadioButton("Snap To Grid");

		mapCanvas = new MapCanvas(blockPane);

		gridX = new JTextField();
		gridY = new JTextField();
		gridSnapX = new JTextField();
		gridSnapY = new JTextField();

		gridSnapX.setEnabled(false);
		gridSnapY.setEnabled(false);

		mapCanvas.setMapAssetPane(mapAssets);

		if (snapToGrid.isSelected()) {
			gridSnapX.setEnabled(true);
			gridSnapX.setEnabled(true);
		}
		mapAssets.setMapPanel(mapCanvas);
		
		
		
		gridY.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				if (gridY.getText().equals("")) {
					gridYValue = 32;

				} else {
					gridYValue = Integer.parseInt(gridY.getText());
				}

				if (doDrawGrid) {
					drawGrid.setSelected(false);
					drawGrid.setSelected(true);
					mapCanvas.repaint();
				}
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				if (gridY.getText().equals("")) {
					gridYValue = 32;

				} else {
					gridYValue = Integer.parseInt(gridY.getText());
				}

				if (doDrawGrid) {
					drawGrid.setSelected(false);
					drawGrid.setSelected(true);
					mapCanvas.repaint();
				}
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				if (gridY.getText().equals("")) {
					gridYValue = 32;

				} else {
					gridYValue = Integer.parseInt(gridY.getText());
				}

				if (doDrawGrid) {
					drawGrid.setSelected(false);
					drawGrid.setSelected(true);
					mapCanvas.repaint();
				}
			}
		});
		gridX.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				if (gridX.getText().equals("")) {
					gridXValue = 32;

				} else {
					gridXValue = Integer.parseInt(gridX.getText());
				}

				if (doDrawGrid) {
					drawGrid.setSelected(false);
					drawGrid.setSelected(true);
					mapCanvas.repaint();
				}
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				if (gridX.getText().equals("")) {
					gridXValue = 32;

				} else {
					gridXValue = Integer.parseInt(gridX.getText());
				}

				if (doDrawGrid) {
					drawGrid.setSelected(false);
					drawGrid.setSelected(true);
					mapCanvas.repaint();
				}
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				if (gridX.getText().equals("")) {
					gridXValue = 32;

				} else {
					gridXValue = Integer.parseInt(gridX.getText());
				}

				if (doDrawGrid) {
					drawGrid.setSelected(false);
					drawGrid.setSelected(true);
					mapCanvas.repaint();
				}
			}
		});

		gridSnapY.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				if (gridSnapY.getText().equals("")) {
					gridSnapYValue = 32;

				} else {
					gridSnapYValue = Integer.parseInt(gridSnapY.getText());
				}

				if (doSnapToGrid) {
					mapCanvas.setGridSnapSize(gridSnapXValue, gridSnapYValue);

				}
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				if (gridSnapY.getText().equals("")) {
					gridSnapYValue = 32;

				} else {
					gridSnapYValue = Integer.parseInt(gridSnapY.getText());
				}

				if (doSnapToGrid) {
					mapCanvas.setGridSnapSize(gridSnapXValue, gridSnapYValue);

				}
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				if (gridSnapY.getText().equals("")) {
					gridSnapYValue = 32;

				} else {
					gridSnapYValue = Integer.parseInt(gridSnapY.getText());
				}

				if (doSnapToGrid) {
					mapCanvas.setGridSnapSize(gridSnapXValue, gridSnapYValue);

				}
			}
		});
		gridSnapX.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				if (gridSnapX.getText().equals("")) {
					gridSnapXValue = 32;

				} else {
					gridSnapXValue = Integer.parseInt(gridSnapX.getText());
				}

				if (doSnapToGrid) {
					mapCanvas.setGridSnapSize(gridSnapXValue, gridSnapYValue);

				}
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				if (gridSnapX.getText().equals("")) {
					gridSnapXValue = 32;

				} else {
					gridSnapXValue = Integer.parseInt(gridSnapX.getText());
				}

				if (doSnapToGrid) {
					mapCanvas.setGridSnapSize(gridSnapXValue, gridSnapYValue);

				}
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				if (gridSnapX.getText().equals("")) {
					gridSnapXValue = 32;

				} else {
					gridSnapXValue = Integer.parseInt(gridSnapX.getText());
				}

			}
		});

		drawGrid.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (drawGrid.isSelected()) {
					doDrawGrid = true;
					mapCanvas.setGridSize(gridXValue, gridYValue);
					mapCanvas.drawGrid(true);
					mapCanvas.repaint();
				} else if (drawGrid.isSelected() == false) {
					doDrawGrid = false;
					mapCanvas.drawGrid(false);
					mapCanvas.repaint();
				}
			}
		});

		snapToGrid.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (snapToGrid.isSelected()) {
					gridSnapX.setEnabled(true);
					gridSnapY.setEnabled(true);
					doSnapToGrid = true;
					mapCanvas.setGridSnapSize(gridSnapXValue, gridSnapYValue);
					mapCanvas.setToGridSnap(true);
					mapCanvas.repaint();
				} else if (snapToGrid.isSelected() == false) {
					gridSnapX.setEnabled(false);
					gridSnapY.setEnabled(false);
				}
			}
		});

		toolBar.add(drawGrid);
		toolBar.add(gridX);
		toolBar.add(gridY);

		toolBar.add(snapToGrid);
		toolBar.add(gridSnapX);
		toolBar.add(gridSnapY);

		add(toolBar, BorderLayout.NORTH);
		add(mapCanvas, BorderLayout.CENTER);
		add(mapAssets.scrollPane, BorderLayout.EAST);
	}

}
