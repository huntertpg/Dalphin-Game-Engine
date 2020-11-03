package com.dalphin.engine.desktop.editor.mapEditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.dalphin.engine.desktop.editor.childpane.BlockPane;

public class MapCanvas extends JPanel {

	private int width;
	private int height;
	private int blockX;
	private int blockY;
	private int mouseX;
	private int mouseY;
	private int gridXSize = 32;
	private int gridYSize = 32;
	private int gridXSnap = 32;
	private int gridYSnap = 32;
	private BlockPane blockPane;
	private boolean drawGrid;
	private boolean snapToGrid;
	private MapAssetPane mapAssets;

	public MapCanvas(BlockPane blockPane) {
		this.blockPane = blockPane;
		this.width = width;
		this.height = height;
		setBackground(Color.DARK_GRAY);
		add(new MapGraphics());

	}

	public void setToGridSnap(boolean snapToGrid) {
		this.snapToGrid = snapToGrid;
	}

	public void drawGrid(boolean drawGrid) {
		this.drawGrid = drawGrid;
	}

	public void setGridSize(int gridXSize, int gridYSize) {
		this.gridXSize = gridXSize;
		this.gridYSize = gridYSize;
	}

	public void setGridSnapSize(int gridXSize, int gridYSize) {
		this.gridXSnap = gridXSize;
		this.gridYSnap = gridYSize;
	}

	private class MapGraphics extends JComponent {

		public MapGraphics() {

			addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub

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
				public void mouseClicked(MouseEvent e) {
					if (mapAssets != null) {
						if (snapToGrid) {
							mapAssets.addBlock(blockPane.getActiveButton().getIcon(),
									blockPane.getActiveButton().getText(), blockX, blockY);
						} else {
							mapAssets.addBlock(blockPane.getActiveButton().getIcon(),
									blockPane.getActiveButton().getText(), mouseX, mouseY);
						}
					}
				}
			});

			addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseMoved(MouseEvent e) {
					mouseX = e.getX() - 10;
					mouseY = e.getY() - 10;
					repaint();
				}

				@Override
				public void mouseDragged(MouseEvent e) {
					mouseX = e.getX() - 10;
					mouseY = e.getY() - 10;
					repaint();
				}
			});
		}

		public void drawBlocks(Graphics g, MapAssetPane mapAssets) {
			if (mapAssets != null) {
				mapAssets.draw(g);
			}
		}

		@Override
		public void paint(Graphics g) {
			drawBlocks(g, mapAssets);
			setSize((getParent().getWidth()), getParent().getHeight());
			// - (getParent().getWidth() / 8))
			setLocation(0, 0);
			if (drawGrid) {
				g.setColor(new Color(184, 184, 184));
				drawGrid(g, gridXSize, gridYSize);
			}
			if (snapToGrid) {
				snapToGrid(g, gridXSnap, gridYSnap);
			} else {
				blockPane.getActiveButton().getIcon().paintIcon(this, g, mouseX, mouseY);

			}
			// g.fillRect(0, 0, getWidth(), getHeight());
			super.paint(g);
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
	}

	/**
	 * @return the blockX
	 */
	public int getBlockX() {
		return blockX;
	}

	/**
	 * @param blockX the blockX to set
	 */
	public void setBlockX(int blockX) {
		this.blockX = blockX;
	}

	/**
	 * @return the blockY
	 */
	public int getBlockY() {
		return blockY;
	}

	/**
	 * @param blockY the blockY to set
	 */
	public void setBlockY(int blockY) {
		this.blockY = blockY;
	}

	public void setMapAssetPane(MapAssetPane mapAssets) {
		this.mapAssets = mapAssets;
	}
}
