package com.dalphin.engine.managers;

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
		axe = new ItemAxe("Axe", textureManager.dungeonSpriteSheet[5][21], debug);
	}

}
