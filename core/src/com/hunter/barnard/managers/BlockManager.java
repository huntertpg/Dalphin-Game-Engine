package com.hunter.barnard.managers;

import com.hunter.barnard.block.Block2D;
import com.hunter.barnard.block.BlockBrick;

public class BlockManager {
	
	public Block2D brick;
	public Block2D brickTop;
	public Block2D brickFloor;
	
	public BlockManager(TextureManager textureManager) {
		brickTop = new BlockBrick("Brick", textureManager.dungeonSpriteSheet[0][1], 16, 16);
		brick = new BlockBrick("Brick", textureManager.dungeonSpriteSheet[1][1], 16, 16);
		brickFloor = new BlockBrick("Brick", textureManager.dungeonSpriteSheet[4][1], 16, 16);
	}

}
