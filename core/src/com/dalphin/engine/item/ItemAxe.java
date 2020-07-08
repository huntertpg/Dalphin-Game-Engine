package com.dalphin.engine.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dalphin.engine.debug.DebugUtil;

public class ItemAxe extends Item2D{

	public ItemAxe(String name, TextureRegion texture, int textureXOffset, int textureYOffset, int textureWidth, int textureHeight, DebugUtil debug) {
		super(name, texture, textureXOffset, textureYOffset,textureWidth, textureHeight, debug);
	}

}
