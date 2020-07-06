/** @author: Hunter Barnard
 * 
 * This class is basically the game. It does the main methods such as create, render and dispose
 * There are other functions such as pause and unpause that will be added later.
 * This class calls other classes for all the heavy lifting.
 * 
 */

package com.dalphin.engine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dalphin.engine.debug.DebugUtil;
import com.dalphin.engine.managers.AnimationManager;
import com.dalphin.engine.managers.AssetManager;
import com.dalphin.engine.managers.BlockManager;
import com.dalphin.engine.managers.ItemManager;
import com.dalphin.engine.managers.TextureManager;
import com.dalphin.engine.player.Player2D;
import com.dalphin.engine.player.Player2DMovement;
import com.dalphin.engine.player.TestPlayer;
import com.dalphin.engine.render.Basic2DRenderer;
import com.dalphin.engine.util.KeyboardInputHandler;
import com.dalphin.engine.world.WorldGen;

public class LibGDXTestGame extends ApplicationAdapter {
	
	AnimationManager animationManager;
	
	AssetManager assetManager;
	
	//Create a sprite batch for rendering - this method will be moved to the renderers later on
	SpriteBatch batch;
	
	DebugUtil debugUtil;
	
	float elapsedTime;
	
	//This is the input manager for handing user input in the form of a keyboard - there will be
	//a controller and mouse input manager later on
	KeyboardInputHandler input;
	
	//This is the player class. This will later be put in a map class as this is just a player object
	//that contains a player texture, move speed, etc...
	Player2D player;
	
	//this is the player movement class that takes in the input manager and modifies the players data based on that
	Player2DMovement playerMovement;
	
	int pos = 0;
	
	//This is the main renderer for 2D rendering. It contains the orthagraphic camera and will be 
	//in charge of rendering for now.
	Basic2DRenderer renderer;
	
	WorldGen world;
	/**
	 * This is the create method. This is basically where all the initialization is done to get
	 * assets loaded up, input managers set, and the initialization of objects such as renderers
	 * players, etc...
	 */
	@Override
	public void create () {
		
		//init the SpriteBatch that is used for rendering things to the screen
		batch = new SpriteBatch();
		
		debugUtil = new DebugUtil();
		debugUtil.enableDebugging(true);
		debugUtil.Debug();
		assetManager = new AssetManager(debugUtil);
		assetManager.InitManagers();
		world = new WorldGen(assetManager.blockManager(), debugUtil);
		world.genorateWorld();
		//init the renderer that creates the camera and will eventually be used for all basic
		//2D rendering
		renderer = new Basic2DRenderer(batch, assetManager.textureManager(), 1280, 720);
		
		//init the input handler for keyboard input
		input = new KeyboardInputHandler();
		
		//init a player object (currenly just used for testing)
		player = new TestPlayer(assetManager.textureManager(), "Test", 100, assetManager.textureManager().playerSheet);
		player.setPlayerTexture(assetManager.textureManager().playerSheet);
		
		//set the default input processor to the keyboard input manager - this needs to be done or else
		//input from the input manager will not work
		Gdx.input.setInputProcessor(input);
		
		animationManager = new AnimationManager(assetManager.textureManager());
		
		playerMovement = new Player2DMovement(input, player, batch, animationManager);
		
		assetManager.blockManager().brickTop.setyPos(32);
		assetManager.blockManager().brickFloor.setyPos(-32);		
		
	}
	
	/**
	 * This is required as it disposes of all things that were loaded into memory such as textures and sounds
	 */
	@Override
	public void dispose () {
		
		//This tells the sprite batch to dispose everything(such as the camera and such)
		batch.dispose();
		//this tells the texture manager to dispose all of its textures from memory
		assetManager.dispose();
	}

	/**
	 * this method is required - it renders things to the screen however the main bulk of this will be done in the
	 * renderer of choice (that being the basic 2d renderer, 3D renderer etc...)
	 */
	@Override
	public void render () {
		
		//This sets the clear color of open GL every frame buffer that is rendered - I.E it clears the screen
		// with this color
		Gdx.gl.glClearColor(0, 0, 0, 1);
		
		//this actually clears the screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//this tells the Basic2DRenderer to render things to the screen - this is called every render cycle
		renderer.render();
	    elapsedTime += Gdx.graphics.getDeltaTime();

		//This tells the sprite batch to begin another batch to render - all rendering is done between this and .end();
		batch.begin();
		world.drawWorld(batch);

		//this draws the player to the screen by obtaining the players texture from the player object, getting the players current
		//at the current players x and y position
		//this ends the drawing of things to the screen
		playerMovement.update(Gdx.graphics.getDeltaTime());
		System.out.println(world.worldBlocks.get(0).getPos());
		batch.end();

		//this method checks for any updates that may occur (such as player input and modifcation to the player position)
		update();
	}
	
	/**
	 * this method isn't require but is called every render cycle to check for user input and to see if anything
	 * data wise has changed and if so it is modified
	 */
	public void update() {
		
	}
}
