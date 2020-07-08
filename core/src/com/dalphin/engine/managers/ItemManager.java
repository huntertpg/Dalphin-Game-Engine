package com.dalphin.engine.managers;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dalphin.engine.debug.DebugUtil;
import com.dalphin.engine.item.Item2D;
import com.dalphin.engine.item.ItemAxe;

public class ItemManager {
	
	public Item2D axe;
	private DebugUtil debug;
	
	/**
	 * 
	 * @param textureManager
	 * @param debug
	 */
	public ItemManager(TextureManager textureManager, DebugUtil debug) {
		this.debug = debug;
		axe = new ItemAxe("Axe", textureManager.dungeonSpriteSheet[3][18], 0, -4, 0, 20, debug);
	}

}
