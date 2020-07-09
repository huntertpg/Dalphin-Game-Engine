package com.dalphin.engine.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dalphin.engine.debug.DebugUtil;

public class ItemAxe extends Item2D{
	/**
	 * 
	 * @param name
	 * @param texture
	 * @param textureXOffset
	 * @param textureYOffset
	 * @param textureWidth
	 * @param textureHeight
	 * @param debug
	 */
	public ItemAxe(String name, TextureRegion texture, int textureXOffset, int textureYOffset, int textureWidth, int textureHeight, DebugUtil debug) {
		super(name, texture, textureXOffset, textureYOffset,textureWidth, textureHeight, debug);
	}

}
