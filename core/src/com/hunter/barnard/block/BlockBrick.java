package com.hunter.barnard.block;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BlockBrick extends Block2D{

	public BlockBrick(String name, TextureRegion texture, int blockWidth, int blockHeight) {
		super(name, texture, blockWidth, blockHeight);
	}

	@Override
	public void draw(Batch batch) {
		super.draw(batch);
	}
	
	

}
