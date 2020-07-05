package com.dalphin.engine.managers;

import com.dalphin.engine.util.Animation2D;

public class AnimationManager {
	
	public Animation2D idleAnimation;
	public Animation2D walkRightAnimation;
	public Animation2D walkLeftAnimation;
	
	public AnimationManager(TextureManager textureManager) {
		idleAnimation = new Animation2D(textureManager.playerSheet, 1, 1, 13, 32, 32, false, false);
		walkRightAnimation = new Animation2D(textureManager.playerSheet, 2, 1, 8, 32, 32, false, false);
		walkLeftAnimation = new Animation2D(textureManager.playerSheet, 2, 1, 8, 32, 32, true, false);
	}

}
