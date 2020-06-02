package com.hunter.barnard.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.hunter.barnard.managers.TextureManager;
import com.hunter.barnard.util.Animation2D;

public class TestPlayer extends Player2D {


	float timeElapsed;
	
	public TestPlayer(TextureManager textureManager, String name, float moveSpeed, Texture texture) {
		super(textureManager, name, moveSpeed, texture);
		super.setPlayerWidth(32);
		super.setPlayerHeight(32);
	}
	
	@Override
	public void draw(Batch batch, float timeElapsed) {
		//super.draw(batch, parentAlpha);
	}

}
