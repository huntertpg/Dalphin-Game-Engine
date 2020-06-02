package com.hunter.barnard.managers;

import com.hunter.barnard.item.Item2D;
import com.hunter.barnard.item.ItemAxe;

public class ItemManager {
	
	public Item2D axe;
	
	public ItemManager() {
		axe = new ItemAxe("Axe", "star.png");
	}

}
