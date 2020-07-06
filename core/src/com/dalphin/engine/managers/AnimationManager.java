package com.dalphin.engine.managers;

import com.dalphin.engine.util.Animation2D;

public class AnimationManager {
	
	public Animation2D idleAnimation;
	public Animation2D walkRightAnimation;
	public Animation2D walkLeftAnimation;
	/**
	 * 
	 * @param textureManager
	 */
	public AnimationManager(TextureManager textureManager) {
		idleAnimation = new Animation2D(textureManager.dungeonSpriteSheet[1][1].getTexture(), 10f, 3, 8, 1, 12, 16, 16, false, false, 0, 4);
		//idleAnimation = new Animation2D(textureManager.playerSheet, 1, 0, 1, 13, 32, 32, false, false);
		walkRightAnimation = new Animation2D(textureManager.dungeonSpriteSheet[1][1].getTexture(), 10f, 3, 13, 1, 16, 16, 16, false, false, 0, 4);
		walkLeftAnimation = new Animation2D(textureManager.dungeonSpriteSheet[1][1].getTexture(), 10f, 3, 13, 1, 16, 16, 16, true, false, 0, 4);
		
	}

}
