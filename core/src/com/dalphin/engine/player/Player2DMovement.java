package com.dalphin.engine.player;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.dalphin.engine.managers.AnimationManager;
import com.dalphin.engine.util.KeyboardInputHandler;

public class Player2DMovement {
	
	private Player2D player;
	private KeyboardInputHandler keyboardInputHandler;
	private AnimationManager animationManager;
	private Batch batch;
	private float elapsedTime;
	/**
	 * 
	 * @param keyboardInputHandler
	 * @param player
	 * @param batch
	 * @param animationManager
	 */
	public Player2DMovement(KeyboardInputHandler keyboardInputHandler, Player2D player, Batch batch, 
			AnimationManager animationManager) {
		
		this.player = player;
		this.keyboardInputHandler = keyboardInputHandler;
		this.animationManager = animationManager;
		this.batch = batch;
	}
	/**
	 * 
	 * @param deltaTime
	 */
	public void update(float deltaTime) {

		elapsedTime += deltaTime;
  
		if(keyboardInputHandler.isUp()) {
			player.setPlayerY(player.getPlayerY() + player.getPlayerMoveSpeed() * deltaTime);
			animationManager.walkLeftAnimation.draw(batch, elapsedTime, player.getPlayerWidth(), player.getPlayerHeight(), player.getPlayerX(), player.getPlayerY());
		} else if(keyboardInputHandler.isDown()) {
			player.setPlayerY(player.getPlayerY() - player.getPlayerMoveSpeed() * deltaTime);
			animationManager.walkLeftAnimation.draw(batch, elapsedTime, player.getPlayerWidth(), player.getPlayerHeight(), player.getPlayerX(), player.getPlayerY());
		} else if(keyboardInputHandler.isLeft()) {
			player.setPlayerX(player.getPlayerX() - player.getPlayerMoveSpeed() * deltaTime);
			animationManager.walkLeftAnimation.draw(batch, elapsedTime, player.getPlayerWidth(), player.getPlayerHeight() , player.getPlayerX(), player.getPlayerY());
		} else if(keyboardInputHandler.isRight()) {
			player.setPlayerX(player.getPlayerX() + player.getPlayerMoveSpeed() * deltaTime);
			animationManager.walkRightAnimation.draw(batch, elapsedTime, player.getPlayerWidth(), player.getPlayerHeight(), player.getPlayerX(), player.getPlayerY());
		}else {
			animationManager.idleAnimation.draw(batch, elapsedTime, player.getPlayerWidth(), player.getPlayerWidth(), player.getPlayerX(), player.getPlayerY());

		}
	}

}
