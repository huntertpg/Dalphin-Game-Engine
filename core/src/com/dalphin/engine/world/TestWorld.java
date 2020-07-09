package com.dalphin.engine.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.dalphin.engine.debug.DebugUtil;
import com.dalphin.engine.managers.BlockManager;

import box2dLight.PointLight;

public class TestWorld extends WorldDef{
	public TestWorld(BlockManager blockManager, Vector2 gravity) {
		super(blockManager, gravity);

	} 
	
	@Override
	public void genWorld(DebugUtil debugUtil) {
		super.genWorld(debugUtil);
		this.createRayHandler();
		//this.getLights().add(new PointLight(getRayHandler(), 1000, new Color(1, 1, 1, 1), 1000, 100, -100));
	}
	
	

}
