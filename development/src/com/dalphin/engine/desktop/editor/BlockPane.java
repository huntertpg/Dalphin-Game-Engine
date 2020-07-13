package com.dalphin.engine.desktop.editor;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.dalphin.engine.managers.AssetManager;
import com.dalphin.engine.managers.BlockManager;


public class BlockPane {
	
	AssetManager assetManager;
	JPanel pane;
	JLabel label;
	BufferedImage image;
	Image icon;
	Pixmap pixmap;
	
	public BlockPane(AssetManager assetManager) {
		pane = new JPanel();
		try {
			for(int i = 0; i < assetManager.blockManager().blocks.size(); i++) {
				String path = ((FileTextureData)assetManager.blockManager().getBlock(i).getTexture().getTextureData()).getFileHandle().path();
				image = ImageIO.read(new File("../core/assets/" + path));
				image = image.getSubimage(assetManager.blockManager().getBlock(i).getTextureRegion().getRegionX(), 
						assetManager.blockManager().getBlock(i).getTextureRegion().getRegionY(), 
						assetManager.blockManager().getBlock(i).getTextureRegion().getRegionWidth(), assetManager.blockManager().getBlock(i).getTextureRegion().getRegionHeight());
				icon = image.getScaledInstance(image.getWidth() * 2, image.getHeight() * 2, Image.SCALE_DEFAULT);
				label = new JLabel(new ImageIcon(icon));
				pane.add(label);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public JPanel getPanel() {
		return this.pane;
	}
}
