package com.dalphin.engine.managers;

import java.util.ArrayList;

import com.dalphin.engine.block.Block2D;
import com.dalphin.engine.block.BlockBrick;
import com.dalphin.engine.debug.DebugUtil;

public class BlockManager {
	
	public ArrayList<Block2D> blocks = new ArrayList<Block2D>();
	
	/**
	 * 
	 * @param textureManager
	 * @param debug
	 */
	public BlockManager(TextureManager textureManager, DebugUtil debug) {
		blocks.add(new BlockBrick("Brick Top", this.blocks.size(), textureManager.dungeonSpriteSheet[0][1], 32, 32, debug));
		blocks.add(new BlockBrick("Brick", this.blocks.size(), textureManager.dungeonSpriteSheet[1][1], 32, 32, debug));
		blocks.add(new BlockBrick("Brick Floor", this.blocks.size(), textureManager.dungeonSpriteSheet[4][1], 32, 32, debug));
		blocks.add(new BlockBrick("Brick Wall Right", this.blocks.size(), textureManager.dungeonSpriteSheet[8][1], 32, 32, debug));
		blocks.add(new BlockBrick("Brick Wall Left", this.blocks.size(), textureManager.dungeonSpriteSheet[8][0], 32, 32, debug));
		blocks.add(new BlockBrick("Brick Wall End Left", this.blocks.size(), textureManager.dungeonSpriteSheet[9][0], 32, 32, debug));
		blocks.add(new BlockBrick("Brick Wall End Right", this.blocks.size(), textureManager.dungeonSpriteSheet[9][1], 32, 32, debug));
		blocks.add(new BlockBrick("Brick Wall Corner Top Left", this.blocks.size(), textureManager.dungeonSpriteSheet[7][2], 32, 32, debug));
		blocks.add(new BlockBrick("Flag Red Wall", this.blocks.size(), textureManager.dungeonSpriteSheet[2][1], 32, 32, debug));
		blocks.add(new BlockBrick("Cracked Floor", this.blocks.size(), textureManager.dungeonSpriteSheet[4][2], 32, 32, debug));
	}
	/**
	 *  
	 * @param index
	 * @return block
	 */
	public Block2D getBlock(int index) {
		return this.blocks.get(index);
	}

	
}
