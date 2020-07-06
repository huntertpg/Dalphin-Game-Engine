package com.dalphin.engine.managers;

import java.util.ArrayList;

import com.dalphin.engine.block.Block2D;
import com.dalphin.engine.block.BlockBrick;
import com.dalphin.engine.debug.DebugUtil;

public class BlockManager {
	
	public Block2D brick;
	public Block2D brickTop;
	public Block2D brickFloor;
	public Block2D blockWallRight;
	public Block2D blockWallLeft;
	public Block2D blockWallEndLeft;
	public Block2D blockWallEndRight;
	public Block2D blockWallCornerTopLeft;
	public ArrayList<Block2D> blocks = new ArrayList<Block2D>();
	
	public BlockManager(TextureManager textureManager, DebugUtil debug) {
		blocks.add(brickTop = new BlockBrick("Brick Top", textureManager.dungeonSpriteSheet[0][1], 16, 16, debug));
		blocks.add(brick = new BlockBrick("Brick", textureManager.dungeonSpriteSheet[1][1], 16, 16, debug));
		blocks.add(brickFloor = new BlockBrick("Brick Floor", textureManager.dungeonSpriteSheet[4][1], 16, 16, debug));
		blocks.add(blockWallRight = new BlockBrick("Brick Wall Right", textureManager.dungeonSpriteSheet[8][1], 16, 16, debug));
		blocks.add(blockWallLeft = new BlockBrick("Brick Wall Left", textureManager.dungeonSpriteSheet[8][0], 16, 16, debug));
		blocks.add(blockWallEndLeft = new BlockBrick("Brick Wall End Left", textureManager.dungeonSpriteSheet[9][0], 16, 16, debug));
		blocks.add(blockWallEndRight = new BlockBrick("Brick Wall End Right", textureManager.dungeonSpriteSheet[9][1], 16, 16, debug));
		blocks.add(blockWallCornerTopLeft = new BlockBrick("Brick Wall Corner Top Left", textureManager.dungeonSpriteSheet[7][2], 16, 16, debug));
	}
	
	public Block2D getBlock(int index) {
		return this.blocks.get(index);
	}

}
