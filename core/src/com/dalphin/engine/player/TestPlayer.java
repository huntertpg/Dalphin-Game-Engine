package com.dalphin.engine.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.dalphin.engine.managers.AnimationManager;
import com.dalphin.engine.managers.TextureManager;

public class TestPlayer extends Player2D {


	private float timeElapsed;
	private boolean isUp;
	private boolean isDown;
	private boolean isLeft;
	private boolean isRight;
	private Player2DMovement movement;
	private float deltaTime;
	/**
	 * 
	 * @param textureManager
	 * @param name
	 * @param moveSpeed
	 * @param texture
	 */
	public TestPlayer(AnimationManager animationManager, String name, float moveSpeed) {
		super(animationManager, name, moveSpeed);
		super.setPlayerWidth(32);
		super.setPlayerHeight(32);
		super.setXMoveSpeed(0);
		super.setYMoveSpeed(0);
		this.setAnimationManager(animationManager);
		this.addAnimation(animationManager.walkLeftAnimation);
		this.addAnimation(animationManager.walkRightAnimation);
		this.addAnimation(animationManager.idleAnimation);
	}
	@Override
	public void update() {
		super.update();
		if(getXMoveSpeed() > 0) {
			isRight = true; 
		}else if(getXMoveSpeed() < 0) {
			isLeft = true;
		}else if(getYMoveSpeed() > 0) {
			isUp = true;
		}else if(getYMoveSpeed() < 0) {
			isDown = true;
		}else {
			isRight = false;
			isLeft = false;
			isUp = false;
			isDown = false;
		}
	}
	/**
	 * 
	 * @param animationManager
	 * @param timeElapsed
	 */
	@Override
	public void draw(Batch batch, float timeElapsed) {
		if(isUp) {
			getAnimation(0).draw(batch, timeElapsed, this.getPlayerWidth(), this.getPlayerHeight(), this.getPlayerX(), this.getPlayerY());
		}else if(isDown) {
			getAnimation(0).draw(batch, timeElapsed, this.getPlayerWidth(), this.getPlayerHeight(), this.getPlayerX(), this.getPlayerY());
		}else if(isLeft) {
			getAnimation(0).draw(batch, timeElapsed, this.getPlayerWidth(), this.getPlayerHeight(), this.getPlayerX(), this.getPlayerY());
		}else if(isRight) {
			getAnimation(1).draw(batch, timeElapsed, this.getPlayerWidth(), this.getPlayerHeight(), this.getPlayerX(), this.getPlayerY());
		}else {
			getAnimation(2).draw(batch, timeElapsed, this.getPlayerWidth(), this.getPlayerHeight(), this.getPlayerX(), this.getPlayerY());
		}
	}

}
