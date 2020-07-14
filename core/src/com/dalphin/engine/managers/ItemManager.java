package com.dalphin.engine.managers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dalphin.engine.debug.DebugUtil;
import com.dalphin.engine.item.Item2D;
import com.dalphin.engine.item.ItemAxe;

public class ItemManager {
	
	public Item2D axe;
	private DebugUtil debug;
	public ArrayList<Item2D> items = new ArrayList<Item2D>();
	
	/**
	 * 
	 * @param textureManager
	 * @param debug
	 */
	public ItemManager(TextureManager textureManager, DebugUtil debug) {
		this.debug = debug;
		axe = new ItemAxe("Axe", textureManager.dungeonSpriteSheet[6][21], 0, -7, 5, 8, debug);
		axe.setItemHeight(32);
		axe.setItemWidth(32);
		items.add(axe);
	}

}
