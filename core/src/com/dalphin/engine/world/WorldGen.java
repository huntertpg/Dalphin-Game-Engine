package com.dalphin.engine.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.dalphin.engine.block.Block2D;
import com.dalphin.engine.debug.DebugUtil;
import com.dalphin.engine.managers.BlockManager;

public class WorldGen {
	
	private DebugUtil debug;
	private int[] worldLayerOne;
	private int[] worldLayerTwo;
	private BlockManager blockManager;
	public ArrayList<Block2D> worldBlocks = new ArrayList<Block2D>();
	public World world;
	/**
	 * 
	 * @param blockManager
	 * @param debug
	 */
	public WorldGen(BlockManager blockManager, DebugUtil debug) {
		
		world = new World(new Vector2(0, 0f), true);
		
		this.debug = debug;
		this.blockManager = blockManager;
		worldLayerOne = new int[] 
				          		 {2,2,2,2,2,2,2,2,2,2,2,100,
				        		  2,2,2,2,2,2,2,2,2,2,2,100,
				        		  2,2,2,2,2,2,2,2,2,2,2,100,
				        		  2,2,2,2,2,2,2,2,2,2,2,100};
		worldLayerTwo = new int[] 
				  {};
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
				yPos -= 31;
				xPos = 0;
			}else if(worldLayerOne[i] == 90) {
				xPos +=31;
			}else {
				block = new Block2D(blockManager.getBlock(worldLayerOne[i]).getName(), blockManager.getBlock(worldLayerOne[i]).getTextureRegion(), blockManager.getBlock(worldLayerOne[i]).getBlockWidth(), blockManager.getBlock(worldLayerOne[i]).getBlockHeight());
				block.setPos(new Vector2(xPos, yPos));
				block.createBody(world, BodyType.DynamicBody);
				block.canRotate(true);
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
				block.createBody(world, BodyType.DynamicBody);
				worldBlocks.add(block);
				xPos +=32;
			}
			
		}
		
	}
	/**
	 * 
	 * @param batch
	 */
	public void drawWorld(Batch batch, float elapsedTime) {
		world.step(1/60f, 6, 2);

		for(int i = 0; i < worldBlocks.size(); i++) {
			worldBlocks.get(i).draw(batch, 2);
			}
		}
}
