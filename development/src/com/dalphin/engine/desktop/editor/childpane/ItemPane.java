package com.dalphin.engine.desktop.editor.childpane;


import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.dalphin.engine.desktop.editor.EditorTheme;
import com.dalphin.engine.desktop.editor.components.DalphinButton;
import com.dalphin.engine.managers.AssetManager;


public class ItemPane {
	
	private AssetManager assetManager;
	private JPanel pane;
	private BufferedImage image;
	private Image icon;
	private DalphinButton button;
	private EditorTheme editorTheme;
	private ArrayList<DalphinButton> buttons = new ArrayList<DalphinButton>();
	/**
	 * 
	 * @param assetManager
	 */
	public ItemPane(AssetManager assetManager) {
		pane = new JPanel();
		try {
			for(int i = 0; i < assetManager.itemManager().items.size(); i++) {
				String path = ((FileTextureData)assetManager.itemManager().items.get(i).getTexture().getTextureData()).getFileHandle().path();
				image = ImageIO.read(new File("../core/assets/" + path));
				image = image.getSubimage(assetManager.itemManager().items.get(i).getTextureRegion().getRegionX(), 
						assetManager.itemManager().items.get(i).getTextureRegion().getRegionY(), 
						assetManager.itemManager().items.get(i).getTextureRegion().getRegionWidth(), assetManager.itemManager().items.get(i).getTextureRegion().getRegionHeight());
				icon = image.getScaledInstance(image.getWidth() * 2, image.getHeight() * 2, Image.SCALE_DEFAULT);
				if(editorTheme == null) {
					button = new DalphinButton(assetManager.itemManager().items.get(i).getName(),new ImageIcon(icon), null);
					
				}else {
					button = new DalphinButton(assetManager.itemManager().items.get(i).getName(),new ImageIcon(icon), editorTheme);	
					
				}
				button.setPreferredSize(new Dimension(100, 100));
				button.setHorizontalTextPosition(JButton.CENTER);
				button.setVerticalTextPosition(JButton.BOTTOM);
				button.setToolTipText(assetManager.itemManager().items.get(i).getName());
				buttons.add(button);
				pane.add(button);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @return
	 */
	public JPanel getPanel() {
		return this.pane;
	}
	/**
	 * 
	 * @param editorTheme
	 */
	public void setEditorTheme(EditorTheme editorTheme) {
		this.editorTheme = editorTheme;
		for(int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setEditorTheme(editorTheme);
		}
	}
}
