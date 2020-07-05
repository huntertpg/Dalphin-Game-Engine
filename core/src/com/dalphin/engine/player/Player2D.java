/* Author: Hunter Barnard
 * 
 * This is the Player Object class. This class if for declaring what makes up a player.
 * This handles texturing of the player, the player move speed, the player position, as well as getters
 * and setters for each of these values. This will communicate with the player movement class to get
 * input from the player to modify values of the player
 * 
 */

package com.dalphin.engine.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.dalphin.engine.managers.TextureManager;

public class Player2D extends Actor	{
	
	//this declares the texture manager to get the player texture.
	private TextureManager textureManager;
	
	//this creates the players default texture if one isn't provided
	private Texture DEFAULTTEXTURE;
	
	//this sets the players move speed if one isn't provided
	private float DEFAULTMOVESPEED = 100f;
	
	//this sets the players "username" if one isn't provided
	private String DEFAULTNAME = "Unknown";
	
	//this is the players actual texture
	private Texture texture;
	
	//this is the players actual movespeed
	private float moveSpeed;
	
	//this is the players actual "username"
	private String name;
	
	//declare sthe players x and y position as a Vector2
	private Vector2 pos;
	private float playerWidth;
	private float playerHeight;
	
	//creates the player usinga constructor only taking in the texture manager for loading in the players texture
	public Player2D(TextureManager textureManager) {
		
		//sets the texture manager for this class to the passed in texture manager
		this.textureManager = textureManager;
		
		//sets the default texture to missing texture since the texture manager was declared
		this.DEFAULTTEXTURE = textureManager.missingTexture;
		
		//sets the texture to default texture since one wasn't provided
		this.texture = DEFAULTTEXTURE;
		
		//sets the players movespeed to the default movespeed since one isn't provided
		this.moveSpeed = DEFAULTMOVESPEED;
		
		//sets the players username to the default username since one isn't provided
		this.name = DEFAULTNAME;
		
		//initialize the players position as a vector2
		this.pos = new Vector2();
	}
	
	//creates the player using a constructor that takes in the texture manager and the players name
	public Player2D(TextureManager textureManager, String name) {
		
		//sets the classes texture manager to the passed in texture manager
		this.textureManager = textureManager;
		
		//sets the default texture to the missing texture since the texture manager was set
		this.DEFAULTTEXTURE = textureManager.missingTexture;
		
		//sets the player name to the passed in name
		this.name = name;
		
		//sets the players texture to a missing texture since one wasn't provided
		this.texture = DEFAULTTEXTURE;
		
		//sets the players movespeed to the default movespeed since one wasn't provided
		this.moveSpeed = DEFAULTMOVESPEED;
		
		//initialize the players position as a vector2
		this.pos = new Vector2();
	}
	
	//creates the player using a constructor that takes in a texture manager, a name and a player move speed
	public Player2D(TextureManager textureManager, String name, float moveSpeed) {
		
		//sets the class texture manager to the one that is passed in
		this.textureManager = textureManager;
		
		//sets the default texture to the missing texture since the texture manager was inited
		this.DEFAULTTEXTURE = textureManager.missingTexture;
		
		//sets the player name to the username passed in
		this.name = name;
		
		//sets the players movespeed to the one passed in
		this.moveSpeed = moveSpeed;
		
		//sets the players texture to the default texture since one wasn't provided
		this.texture = DEFAULTTEXTURE;
		
		//initialize the players position as a vector2
		this.pos = new Vector2();
	}

	//creates a player using a constructor that takes in a texture manager, name, movespedd, and player texture
	public Player2D(TextureManager textureManager, String name, float moveSpeed, Texture texture) {
		//sets the classes texture manager to the passed in texture manager
		this.textureManager = textureManager;
		
		//sets the players username to the passed in username
		this.name = name;
		
		//sets the players movespeed to the passed in move speed
		this.moveSpeed = moveSpeed;
		
		//sets the players texture to the passed in texture
		this.texture = texture;
		
		//initialize the players position as a vector2
		this.pos = new Vector2();
		
	}
	
	//this will be used for updating the players position once the player input manager is made
	//will also be used to keep track of positional and texture data
	public void update() {
		
	}
	
	//gets the players current x position in float
	public float getPlayerX() {
		return this.pos.x;
	}
	
	//gets the players current y position in float
	public float getPlayerY() {
		return this.pos.y;
	}
	
	//gets the players current texture
	public Texture getPlayerTexture() {
		return this.texture;
	}
	
	//gets the players current move speed (not to be confused with current speed of velocity, just the set speed)
	public float getPlayerMoveSpeed() {
		return this.moveSpeed;
	}
	
	//sets the players current x position
	public void setPlayerX(float xPos) {
		this.pos.x = xPos;
	}
	
	//sets the players current y position
	public void setPlayerY(float yPos) {
		this.pos.y = yPos;
	}
	
	//sets the players current texture
	public void setPlayerTexture(Texture texture) {
		this.texture = texture;
	}
	
	public void setPlayerHeight(float height) {
		this.playerHeight = height;
	}
	
	public void setPlayerWidth(float width) {
		this.playerWidth = width;
	}
	
	public float getPlayerWidth() {
		return this.playerWidth;
	}
	
	public float getPlayerHeight() {
		return this.playerHeight;
	}
	
	//sets the players current move speed
	public void setPlayerSpeed(float speed) {
		this.moveSpeed = speed;
	}
	
	public void draw(Batch batch, float elapsedTime) {
		batch.draw(this.texture, this.pos.x, this.pos.y);
	}
	
	public void draw(Batch batch, float elapsedTime, float xPos, float yPos) {
		batch.draw(this.texture, this.pos.x, this.pos.y);
	}
}
