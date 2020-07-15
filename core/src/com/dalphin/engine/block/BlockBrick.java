package com.dalphin.engine.block;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dalphin.engine.debug.DebugUtil;

public class BlockBrick extends Block2D{
	/**
	 * 
	 * @param name
	 * @param texture
	 * @param blockWidth
	 * @param blockHeight
	 * @param debugUtil
	 */
	public BlockBrick(String name, int blockID, TextureRegion texture, int blockWidth, int blockHeight, DebugUtil debugUtil) {
		super(name, blockID, texture, blockWidth, blockHeight, debugUtil);
	}
	public BlockBrick(String name, int blockID, Texture texture, int blockWidth, int blockHeight, DebugUtil debug) {
		super(name, blockID, texture, blockWidth, blockHeight, debug);

	}
	/**
	 * 
	 * @param batch
	 */
	@Override
	public void draw(Batch batch) {
		super.draw(batch);
	}
	
	/**
	 * 
	 */
	@Override
	public BlockBrick createBlock() {
		if(this.getTexture() == null) {
			return new BlockBrick(this.getName(), this.getBlockID(), this.getTextureRegion(), this.getBlockWidth(), this.getBlockHeight(),
					this.getDebug());	
		}else {
			return new BlockBrick(this.getName(), this.getBlockID(), this.getTexture(), this.getBlockWidth(), this.getBlockHeight(),
					this.getDebug());
		}
	}
}
