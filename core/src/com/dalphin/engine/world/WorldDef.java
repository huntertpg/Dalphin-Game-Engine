package com.dalphin.engine.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.dalphin.engine.block.Block2D;
import com.dalphin.engine.item.Item2D;
import com.dalphin.engine.player.Player2D;

public class WorldDef {

	private ArrayList<Block2D> worldBlocks = new ArrayList<Block2D>();
	private ArrayList<Player2D> players = new ArrayList<Player2D>();
	private ArrayList<Item2D> items = new ArrayList<Item2D>();
	private World world = new World(new Vector2(0,0), true);
	
	public void genWorld() {
		
	}
	
	public void updateWorld() {
		
	}
	
	public void renderWorld(Batch batch) {
		
	}
}
