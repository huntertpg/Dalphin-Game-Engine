package com.dalphin.engine.desktop.editor.childpane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;

import com.dalphin.engine.desktop.editor.EditorBlock;
import com.dalphin.engine.desktop.editor.mapEditor.MapAssetPane;

public class MapGraphicsPane extends JComponent {
	private boolean drawGrid = false;
	private boolean snapToGrid = false;
	private ArrayList<EditorBlock> blocks = new ArrayList<EditorBlock>();
	int mouseX;
	int mouseY;
	int blockX;
	int blockY;
	boolean gridSnap;
	int clickedX;
	int clickedY;
	int gridXSnap;
	int gridYSnap;
	int gridXSize;
	int gridYSize;
	private int width;
	private int height;
	private BlockPane blockPane;
	private String mapName;
	private MapAssetPane mapAssets;
	
	public MapGraphicsPane(BlockPane blocks, final MapAssetPane mapAssets, int width, int height) {
		this.blockPane = blocks;
		this.width = width;
		this.height = height;
		this.mapAssets = mapAssets;
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (gridSnap) {
					mapAssets.addBlock(blockPane.getActiveButton().getIcon(), blockPane.getActiveButton().getText(),
							blockX, blockY);
					mapAssets.updateUI();
				} else {
					mapAssets.addBlock(blockPane.getActiveButton().getIcon(), blockPane.getActiveButton().getText(),
							e.getX() - 10, e.getY() - 10);
					mapAssets.updateUI();

				}
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				mouseX = e.getX() - 10;
				mouseY = e.getY() - 10;
				repaint();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void drawGrid(Graphics g, int gridXSize, int gridYSize) {

		for (int i = 0; i < getWidth(); i += gridXSize) {
			g.drawLine(i - 10, 0, i - 10, getHeight());
		}

		for (int i = 0; i < getHeight(); i += gridYSize) {
			g.drawLine(0, i - 10, getWidth(), i - 10);
		}

	}

	public void snapToGrid(Graphics g, int gridXSnap, int gridYSnap) {

		blockX = (((mouseX + gridXSnap / 2) / gridXSnap) * gridXSnap) - 10;
		blockY = (((mouseY + gridYSnap / 2) / gridYSnap) * gridYSnap) - 10;
		blockPane.getActiveButton().getIcon().paintIcon(this, g, blockX, blockY);
	}

	@Override
	public void paint(Graphics g) {

		setSize(width, height);
		// setLocation(0, 0);
		if (drawGrid) {
			g.setColor(new Color(184, 184, 184));
			drawGrid(g, gridXSize, gridYSize);
		}

		if (snapToGrid) {
			snapToGrid(g, gridXSnap, gridYSnap);
		} else {
			blockPane.getActiveButton().getIcon().paintIcon(this, g, mouseX, mouseY);

		}
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paint(g);

	}
	

}
