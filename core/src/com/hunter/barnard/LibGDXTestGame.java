/* Author: Hunter Barnard
 * 
 * This class is basically the game. It does the main methods such as create, render and dispose
 * There are other functions such as pause and unpause that will be added later.
 * This class calls other classes for all the heavy lifting.
 * 
 */

package com.hunter.barnard;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hunter.barnard.managers.AnimationManager;
import com.hunter.barnard.managers.BlockManager;
import com.hunter.barnard.managers.ItemManager;
import com.hunter.barnard.managers.TextureManager;
import com.hunter.barnard.player.Player2D;
import com.hunter.barnard.player.Player2DMovement;
import com.hunter.barnard.player.TestPlayer;
import com.hunter.barnard.render.Basic2DRenderer;
import com.hunter.barnard.util.KeyboardInputHandler;

public class LibGDXTestGame extends ApplicationAdapter {
	
	//Create a sprite batch for rendering - this method will be moved to the renderers later on
	SpriteBatch batch;
	
	//Declares the texture manager for loading and creating textures - this will be put in the 
	//asset manager class later on
	TextureManager textureManager;
	
	//This is the main renderer for 2D rendering. It contains the orthagraphic camera and will be 
	//in charge of rendering for now.
	Basic2DRenderer renderer;
	
	//This is the input manager for handing user input in the form of a keyboard - there will be
	//a controller and mouse input manager later on
	KeyboardInputHandler input;
	
	//This is the player class. This will later be put in a map class as this is just a player object
	//that contains a player texture, move speed, etc...
	Player2D player;
	
	//this is the player movement class that takes in the input manager and modifies the players data based on that
	Player2DMovement playerMovement;
	
	ItemManager itemManager;
	BlockManager blockManager;
	
	AnimationManager animationManager;
	
	int pos = 0;
	
	float elapsedTime;
	//This is the create method. This is basically where all the initialization is done to get
	//assets loaded up, input managers set, and the initialization of objects such as renderers
	//players, etc...
	@Override
	public void create () {
		
		//init the SpriteBatch that is used for rendering things to the screen
		batch = new SpriteBatch();
		
		//init the texture manager that holds all the textures
		textureManager = new TextureManager();
		
		//load all the textures into memory
		textureManager.loadAllTextures();
		
		//init the renderer that creates the camera and will eventually be used for all basic
		//2D rendering
		renderer = new Basic2DRenderer(batch, textureManager, 1280, 720);
		
		//init the input handler for keyboard input
		input = new KeyboardInputHandler();
		
		//init a player object (currenly just used for testing)
		player = new TestPlayer(textureManager, "Test", 100, textureManager.playerSheet);
		player.setPlayerTexture(textureManager.playerSheet);
		
		//set the default input processor to the keyboard input manager - this needs to be done or else
		//input from the input manager will not work
		Gdx.input.setInputProcessor(input);
		
		animationManager = new AnimationManager(textureManager);
		
		playerMovement = new Player2DMovement(input, player, batch, animationManager);
		
		itemManager = new ItemManager();
		 
		blockManager = new BlockManager(textureManager);
		
		blockManager.brickTop.setyPos(32);
		blockManager.brickFloor.setyPos(-32);
		
	}
	
	//this method isn't require but is called every render cycle to check for user input and to see if anything
	//data wise has changed and if so it is modified
	public void update() {
		System.out.println(player.getPlayerY());
	}

	//this method is required - it renders things to the screen however the main bulk of this will be done in the
	//renderer of choice (that being the basic 2d renderer, 3D renderer etc...)
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
		//this draws the player to the screen by obtaining the players texture from the player object, getting the players current
		//at the current players x and y position
		//this ends the drawing of things to the screen
		blockManager.brick.draw(batch, 2);
		blockManager.brickTop.draw(batch, 2);
		blockManager.brickFloor.draw(batch, 2);
		playerMovement.update(Gdx.graphics.getDeltaTime());

		batch.end();

		//this method checks for any updates that may occur (such as player input and modifcation to the player position)
		update();
	}
	
	//This is required as it disposes of all things that were loaded into memory such as textures and sounds
	@Override
	public void dispose () {
		
		//This tells the sprite batch to dispose everything(such as the camera and such)
		batch.dispose();
		//this tells the texture manager to dispose all of its textures from memory
		textureManager.disposeAllTextures();
	}
}
