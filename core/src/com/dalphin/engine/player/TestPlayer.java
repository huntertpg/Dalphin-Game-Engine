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
	
	public TestPlayer(TextureManager textureManager, String name, float moveSpeed, Texture texture) {
		super(textureManager, name, moveSpeed, texture);
		super.setPlayerWidth(32);
		super.setPlayerHeight(32);
		super.setXMoveSpeed(0);
		super.setYMoveSpeed(0);
		this.movement = movement;
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
	
	@Override
	public void draw(Batch batch, AnimationManager animationManager, float timeElapsed) {
		if(isUp) {
			animationManager.walkLeftAnimation.draw(batch, timeElapsed, this.getPlayerWidth(), this.getPlayerHeight(), this.getPlayerX(), this.getPlayerY());
		}else if(isDown) {
			animationManager.walkLeftAnimation.draw(batch, timeElapsed, this.getPlayerWidth(), this.getPlayerHeight(), this.getPlayerX(), this.getPlayerY());
		}else if(isLeft) {
			animationManager.walkLeftAnimation.draw(batch, timeElapsed, this.getPlayerWidth(), this.getPlayerHeight(), this.getPlayerX(), this.getPlayerY());
		}else if(isRight) {
			animationManager.walkRightAnimation.draw(batch, timeElapsed, this.getPlayerWidth(), this.getPlayerHeight(), this.getPlayerX(), this.getPlayerY());
		}else {
			animationManager.idleAnimation.draw(batch, timeElapsed, this.getPlayerWidth(), this.getPlayerHeight(), this.getPlayerX(), this.getPlayerY());
		}
	}

}
