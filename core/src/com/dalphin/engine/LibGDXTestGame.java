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
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.dalphin.engine.block.Block2D;
import com.dalphin.engine.debug.DebugUtil;
import com.dalphin.engine.managers.AnimationManager;
import com.dalphin.engine.managers.AssetManager;
import com.dalphin.engine.player.Player2D;
import com.dalphin.engine.player.Player2DMovement;
import com.dalphin.engine.player.TestPlayer;
import com.dalphin.engine.render.Basic2DRenderer;
import com.dalphin.engine.util.KeyboardInputHandler;

import box2dLight.PointLight;
import box2dLight.RayHandler;

public class LibGDXTestGame extends ApplicationAdapter {

	public AssetManager assetManager;
	Box2DDebugRenderer debugRender;

	// Create a sprite batch for rendering - this method will be moved to the
	// renderers later on
	DebugUtil debugUtil;

	float elapsedTime;

	// This is the input manager for handing user input in the form of a keyboard -
	// there will be
	// a controller and mouse input manager later on
	KeyboardInputHandler input;

	// This is the player class. This will later be put in a map class as this is
	// just a player object
	// that contains a player texture, move speed, etc...
	Player2D player;

	// This is the main renderer for 2D rendering. It contains the orthographic
	// camera and will be
	// in charge of rendering for now.
	Basic2DRenderer renderer;
	Player2DMovement playerMovement;
	public boolean isStarted = false;
	/**
	 * This is the create method. This is basically where all the initialization is
	 * done to get assets loaded up, input managers set, and the initialization of
	 * objects such as renderer players, etc...
	 */
	@Override
	public void create() {

		// init the SpriteBatch that is used for rendering things to the screen
		debugUtil = new DebugUtil();
		debugUtil.enableDebugging(true);
		debugUtil.Debug();
		assetManager = new AssetManager();
		assetManager.InitManagers();
		debugRender = new Box2DDebugRenderer(true, false, false, false, false, false);
		
		// init the renderer that creates the camera and will eventually be used for all
		// basic
		// 2D rendering
		renderer = new Basic2DRenderer(assetManager, 1920, 1080, debugUtil);

		// init the input handler for keyboard input
		input = new KeyboardInputHandler();

		// init a player object (currenly just used for testing)
		Gdx.input.setInputProcessor(input);

		player = new TestPlayer(assetManager.animationManager(), "Test", 100);
		playerMovement = new Player2DMovement(player, input, renderer.batch, assetManager.animationManager());
		 
		renderer.playerMovement = playerMovement;
		renderer.player = player;
		renderer.create();
		this.isStarted = true;
	}

	/**
	 * This is required as it disposes of all things that were loaded into memory
	 * such as textures and sounds
	 */
	@Override
	public void dispose() {

		// This tells the sprite batch to dispose everything(such as the camera and
		// such)
		renderer.writer.writeWorld();
		renderer.batch.dispose();
		// this tells the texture manager to dispose all of its textures from memory
		assetManager.dispose();
	}

	/**
	 * this method is required - it renders things to the screen however the main
	 * bulk of this will be done in the renderer of choice (that being the basic 2d
	 * renderer, 3D renderer etc...)
	 */
	@Override
	public void render() {

		// This sets the clear color of open GL every frame buffer that is rendered -
		// I.E it clears the screen
		// with this color
		Gdx.gl.glClearColor(0, 0, 0, 1);

		// this actually clears the screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// this tells the Basic2DRenderer to render things to the screen - this is
		// called every render cycle
		renderer.render();
		elapsedTime += Gdx.graphics.getDeltaTime();
		// this method checks for any updates that may occur (such as player input and
		// modifcation to the player position)
		update();
	}

	/**
	 * this method isn't require but is called every render cycle to check for user
	 * input and to see if anything data wise has changed and if so it is modified
	 */
	public void update() {
		player.update();
		renderer.update();
	}
	
}
