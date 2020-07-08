package com.dalphin.engine.player;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.dalphin.engine.managers.AnimationManager;
import com.dalphin.engine.util.KeyboardInputHandler;

public class Player2DMovement {
	
	private KeyboardInputHandler keyboardInputHandler;
	private Player2D player;
	private float elapsedTime;
	/**
	 * 
	 * @param keyboardInputHandler
	 * @param player
	 * @param batch
	 * @param animationManager
	 */
	public Player2DMovement(Player2D player, KeyboardInputHandler keyboardInputHandler, Batch batch, 
			AnimationManager animationManager) {
		
		this.keyboardInputHandler = keyboardInputHandler;
		this.player = player;
	}
	/**
	 * 
	 * @param deltaTime
	 */
	public void update(float deltaTime) {
		elapsedTime += deltaTime;
		if(keyboardInputHandler.isUp()) {
			player.setYMoveSpeed(2);
			if(player.getBody() != null) {
				player.getBody().applyForceToCenter(new Vector2(0, 1), true);	
			}
			player.setPlayerY(player.getPlayerY() + player.getYMoveSpeed());
		} else if(keyboardInputHandler.isDown()) {
			player.setYMoveSpeed(-2);
			if(player.getBody() != null) {
				player.getBody().applyForceToCenter(new Vector2(0, -1), true);	
			}
			player.setPlayerY(player.getPlayerY() + player.getYMoveSpeed());
		} else if(keyboardInputHandler.isLeft()) {
			player.setXMoveSpeed(-2);
			if(player.getBody() != null) {
				player.getBody().applyForceToCenter(new Vector2(-1, 0), true);	
			}
			player.setPlayerX(player.getPlayerX() + player.getXMoveSpeed());
		} else if(keyboardInputHandler.isRight()) {
			player.setXMoveSpeed(2);
			if(player.getBody() != null) {
				player.getBody().applyForceToCenter(new Vector2(1, 0), true);	
			}
			player.setPlayerX(player.getPlayerX() + player.getXMoveSpeed());
			
		}else {
			player.setYMoveSpeed(0);
			player.setXMoveSpeed(0);
			if(player.getBody() != null) {
				player.getBody().applyForceToCenter(new Vector2(0, 0), true);	
			}
			
		}
	}

}
