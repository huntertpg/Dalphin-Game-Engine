package com.dalphin.engine.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.dalphin.engine.block.Block2D;
import com.dalphin.engine.debug.DebugUtil;
import com.dalphin.engine.managers.BlockManager;

public class WorldGen {
	
	private DebugUtil debug;
	private int[] world;
	private BlockManager blockManager;
	public ArrayList<Block2D> worldBlocks = new ArrayList<Block2D>();
	
	
	public WorldGen(BlockManager blockManager, DebugUtil debug) {
		this.debug = debug;
		this.blockManager = blockManager;
		world = new int[] {5,6,2,2,100,
						   4,3,1,1,100,
						   4,3,0,0,100};
	}
	
	public void genorateWorld() {
		Block2D block;
		float xPos = 0;
		float yPos = 0;
		for(int i = 0; i < world.length; i++) {
			if(world[i] == 100) {
				yPos += 32;
				xPos = 0;
			}else {
				block = new Block2D(blockManager.getBlock(world[i]).getName(), blockManager.getBlock(world[i]).getTextureRegion(), blockManager.getBlock(world[i]).getBlockWidth(), blockManager.getBlock(world[i]).getBlockHeight());
				block.setPos(new Vector2(xPos, yPos));
				worldBlocks.add(block);
				xPos +=32;
			}
			
		}
	}
	
	public void drawWorld(Batch batch) {
		for(int i = 0; i < worldBlocks.size(); i++) {
			worldBlocks.get(i).draw(batch, 2);
		}
	}

}
