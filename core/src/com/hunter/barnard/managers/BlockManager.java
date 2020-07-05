package com.hunter.barnard.managers;

import java.util.ArrayList;

import com.hunter.barnard.block.Block2D;
import com.hunter.barnard.block.BlockBrick;
import com.hunter.barnard.debug.DebugUtil;

public class BlockManager {
	
	public Block2D brick;
	public Block2D brickTop;
	public Block2D brickFloor;
	
	public ArrayList<Block2D> blocks = new ArrayList<Block2D>();
	
	public BlockManager(TextureManager textureManager, DebugUtil debug) {
		blocks.add(brickTop = new BlockBrick("Brick Top", textureManager.dungeonSpriteSheet[0][1], 16, 16, debug));
		blocks.add(brick = new BlockBrick("Brick", textureManager.dungeonSpriteSheet[1][1], 16, 16, debug));
		blocks.add(brickFloor = new BlockBrick("Brick Floor", textureManager.dungeonSpriteSheet[4][1], 16, 16, debug));
	}

}
