package com.dalphin.engine.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.dalphin.engine.block.Block2D;
import com.dalphin.engine.debug.DebugUtil;
import com.dalphin.engine.managers.BlockManager;

public class WorldGen {
	
	private DebugUtil debug;
	private int[] worldLayerOne;
	private int[] worldLayerTwo;
	private BlockManager blockManager;
	public ArrayList<Block2D> worldBlocks = new ArrayList<Block2D>();
	
	/**
	 * 
	 * @param blockManager
	 * @param debug
	 */
	public WorldGen(BlockManager blockManager, DebugUtil debug) {
		this.debug = debug;
		this.blockManager = blockManager;
		worldLayerOne = new int[] 
				          {90,90,90,90,90,90,90,90,90,90,90,90,100,
				           90,1,2,2,2,2,2,2,2,2,2,2,100,
				           90,2,2,2,2,2,2,2,2,2,2,2,100,
				           90,2,2,2,2,2,2,2,2,2,2,2,100,
						   90,2,2,2,2,2,2,2,2,2,2,2,100,
						   90,2,2,2,2,2,2,2,2,2,2,2,100};
		worldLayerTwo = new int[] 
				  {90,0,0,0,0,0,0,0,0,0,0,0,100,
		           4,3,1,1,1,1,1,1,1,1,1,1,100,
		           4,3,90,90,90,90,90,90,90,90,90,90,100,
		           4,3,90,90,90,90,90,90,90,90,90,90,100,
				   4,3,90,90,90,90,90,90,90,90,90,90,100,
				   5,6,90,90,90,90,90,90,90,90,90,90,100};
	}
	/**
	 * 
	 */
	public void genorateWorld() {
		Block2D block;
		float xPos = 0;
		float yPos = 0;
		for(int i = 0; i < worldLayerOne.length; i++) {
			if(worldLayerOne[i] == 100) {
				yPos -= 32;
				xPos = 0;
			}else if(worldLayerOne[i] == 90) {
				xPos +=32;
			}else {
				block = new Block2D(blockManager.getBlock(worldLayerOne[i]).getName(), blockManager.getBlock(worldLayerOne[i]).getTextureRegion(), blockManager.getBlock(worldLayerOne[i]).getBlockWidth(), blockManager.getBlock(worldLayerOne[i]).getBlockHeight());
				block.setPos(new Vector2(xPos, yPos));
				worldBlocks.add(block);
				xPos +=32;
			}
			
		}
		xPos = 0;
		yPos = 0;
		for(int i = 0; i < worldLayerTwo.length; i++) {
			if(worldLayerTwo[i] == 100) {
				yPos -= 32;
				xPos = 0;
			}else if(worldLayerTwo[i] == 90) {
				xPos += 32;
			}else {
				block = new Block2D(blockManager.getBlock(worldLayerTwo[i]).getName(), blockManager.getBlock(worldLayerTwo[i]).getTextureRegion(), blockManager.getBlock(worldLayerTwo[i]).getBlockWidth(), blockManager.getBlock(worldLayerTwo[i]).getBlockHeight());
				block.setPos(new Vector2(xPos, yPos));
				worldBlocks.add(block);
				xPos +=32;
			}
			
		}
	}
	/**
	 * 
	 * @param batch
	 */
	public void drawWorld(Batch batch) {
		for(int i = 0; i < worldBlocks.size(); i++) {
			worldBlocks.get(i).draw(batch, 2);
		}
	}

}
