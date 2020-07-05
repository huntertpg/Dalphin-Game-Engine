package com.hunter.barnard.managers;

import com.hunter.barnard.debug.DebugUtil;
import com.hunter.barnard.item.Item2D;
import com.hunter.barnard.item.ItemAxe;

public class ItemManager {
	
	public Item2D axe;
	private DebugUtil debug;
	
	public ItemManager(TextureManager textureManager, DebugUtil debug) {
		this.debug = debug;
		axe = new ItemAxe("Axe", textureManager.star, debug);
	}

}
