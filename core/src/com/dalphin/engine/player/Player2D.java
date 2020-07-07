/** @author: Hunter Barnard
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
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.dalphin.engine.managers.AnimationManager;
import com.dalphin.engine.managers.TextureManager;

public class Player2D	{
	
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
	private float xMoveSpeed;
	private float yMoveSpeed;
	
	//this is the players actual "username"
	private String name;
	
	//declare sthe players x and y position as a Vector2
	private Vector2 pos;
	private float playerWidth;
	private float playerHeight;
	
	private Body body;
	private BodyDef bodyDef;
	private FixtureDef fixtureDef;
	private Fixture fixture;
	private boolean physicsBody = false;
	
	/**
	 * This constructor creates a player by passing in a texture manager as it will
	 * be needed to set the texture of the player (typing this I realize it should just be a
	 * texture)
	 * @param TextureManager
	 * TODO Change argument from TextureManager to Texture
	 */
	public Player2D(TextureManager textureManager) {
		
		//sets the texture manager for this class to the passed in texture manager
		this.textureManager = textureManager;
		
		//sets the default texture to missing texture since the texture manager was declared
		this.DEFAULTTEXTURE = textureManager.missingTexture;
		
		//sets the texture to default texture since one wasn't provided
		this.texture = DEFAULTTEXTURE;
		
		//sets the players movespeed to the default movespeed since one isn't provided
		this.xMoveSpeed = DEFAULTMOVESPEED;
		this.yMoveSpeed = DEFAULTMOVESPEED;
		//sets the players username to the default username since one isn't provided
		this.name = DEFAULTNAME;
		
		//initialize the players position as a vector2
		this.pos = new Vector2();
	}
	
	/**
	 * Creates the player using a constructor that
	 * takes in the TextureManager and the Player name
	 * @param TextureManager
	 * @param String name
	 * TODO Change TextureManager param to Texture
	 */
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
		this.xMoveSpeed = DEFAULTMOVESPEED;
		
		//initialize the players position as a vector2
		this.pos = new Vector2();
	}
	
	/**
	 * Creates the player using a constructor that takes in a TextureManager, a Name and the Player Move Speed
	 * @param TextureManager
	 * @param String name
	 * @param float moveSpeed
	 * TODO Change TextureManager param to Texture
	 */
	public Player2D(TextureManager textureManager, String name, float moveSpeed) {
		
		//sets the class texture manager to the one that is passed in
		this.textureManager = textureManager;
		
		//sets the default texture to the missing texture since the texture manager was inited
		this.DEFAULTTEXTURE = textureManager.missingTexture;
		
		//sets the player name to the username passed in
		this.name = name;
		
		//sets the players movespeed to the one passed in
		this.yMoveSpeed = moveSpeed;
		
		//sets the players texture to the default texture since one wasn't provided
		this.texture = DEFAULTTEXTURE;
		
		//initialize the players position as a vector2
		this.pos = new Vector2();
	}

	/**
	 * Creates a player using a constructor that takes in a TextureManager, Name, moveSpeed, and Player Texture
	 * @param TextureManager
	 * @param String name
	 * @param float moveSpeed
	 * @param Texture texture
	 * TODO remove this constructor
	 */
	public Player2D(TextureManager textureManager, String name, float moveSpeed, Texture texture) {
		//sets the classes texture manager to the passed in texture manager
		this.textureManager = textureManager;
		//sets the players username to the passed in username
		this.name = name;
		
		//sets the players movespeed to the passed in move speed
		this.xMoveSpeed = moveSpeed;
		this.yMoveSpeed = moveSpeed;
		
		//sets the players texture to the passed in texture
		this.texture = texture;
		
		//initialize the players position as a vector2
		this.pos = new Vector2();
		
	}
	
	/**
	 * This will be used for updating the players position once the player input manager is made
	 * will also be used to keep track of positional and texture data
	 * TODO Do what the comment says as InputManager exists
	 */
	
	public void update() {
		if(physicsBody) {
			body.setTransform((this.pos.x + (this.playerWidth/2)),(this.pos.y + (this.playerHeight / 2)), body.getAngle());	
		}
	}
	
	/**
	 * Gets the players current x position in float
	 * @return float pos.x
	 */
	public float getPlayerX() {
		return this.pos.x;
	}
	
	/** 
	 * Gets the players current y position in float
	 * @return float pos.y
	 */
	public float getPlayerY() {
		return this.pos.y;
	}
	
	/**
	 * Gets the players current texture
	 * @return Texture texture
	 */
	public Texture getPlayerTexture() {
		return this.texture;
	}
	
	/**
	 * Gets the players current move speed (not to be confused with current speed of velocity, just the set speed)
	 * @return float moveSpeed
	 */
	public float getXMoveSpeed() {
		return this.xMoveSpeed;
	}
	
	public float getYMoveSpeed() {
		return this.yMoveSpeed;
	}
	public void setXMoveSpeed(float moveSpeed) {
		this.xMoveSpeed = moveSpeed;
	}
	public void setYMoveSpeed(float moveSpeed) {
		this.yMoveSpeed = moveSpeed;
	}
	
	/**
	 * Sets the players current x position
	 * @param float xPos
	 */
	public void setPlayerX(float xPos) {
		this.pos.x = xPos;
	}
	
	/**
	 * Sets the players current y position
	 * @param float yPos
	 */
	public void setPlayerY(float yPos) {
		this.pos.y = yPos;
	}
	
	/**
	 * Sets the players current texture
	 * @param Texture
	 */
	public void setPlayerTexture(Texture texture) {
		this.texture = texture;
	}
	
	/**
	 * Sets the players height
	 * @param float height
	 */
	public void setPlayerHeight(float height) {
		this.playerHeight = height;
	}
	/**
	 * Sets the players width
	 * @param float width 
	 */
	public void setPlayerWidth(float width) {
		this.playerWidth = width;
	}
	/**
	 * Gets the players width
	 * @return float playerWidth
	 */
	public float getPlayerWidth() {
		return this.playerWidth;
	}
	/**
	 * Gets the players height
	 * @return playerHeight
	 */
	public float getPlayerHeight() {
		return this.playerHeight;
	}
	
	/**
	 * sets the players current move speed
	 * @param speed
	 */

	/**
	 * Draws the player using a batch and takes in the elapsed time
	 * @param Batch
	 * @param float elapsedTime
	 */
	public void draw(Batch batch, float elapsedTime) {
		batch.draw(this.texture, this.pos.x, this.pos.y);
	}
	/**
	 * Draws the player using a batch, as well as where to draw it in the x and y positions
	 * @param batch
	 * @param elapsedTime
	 * @param xPos
	 * @param yPos
	 */
	public void draw(Batch batch, float elapsedTime, float xPos, float yPos) {
		batch.draw(this.texture, this.pos.x, this.pos.y);
	}
	
	public void createBody(World world, BodyType bodyType) {
		bodyDef = new BodyDef();
		bodyDef.type = bodyType;
		bodyDef.position.set(this.pos);
		this.body = world.createBody(bodyDef);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(playerWidth/2, playerHeight/2);
		fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 1f;
		fixture = body.createFixture(fixtureDef);
		shape.dispose();
		physicsBody = true;
	}
	
	public Body getBody() {
		return this.body;
	}

	public void draw(Batch batch, AnimationManager animationManager, float timeElapsed) {
		
	}
}
