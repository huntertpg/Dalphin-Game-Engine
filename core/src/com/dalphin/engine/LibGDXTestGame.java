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
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
import com.dalphin.engine.world.WorldGen;

import box2dLight.PointLight;
import box2dLight.RayHandler;

public class LibGDXTestGame extends ApplicationAdapter {

	AssetManager assetManager;
	Box2DDebugRenderer debugRender;

	// Create a sprite batch for rendering - this method will be moved to the
	// renderers later on
	SpriteBatch batch;

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

	// this is the player movement class that takes in the input manager and
	// modifies the players data based on that

	int pos = 0;

	// This is the main renderer for 2D rendering. It contains the orthographic
	// camera and will be
	// in charge of rendering for now.
	Basic2DRenderer renderer;
	PointLight light;
	Player2DMovement playerMovement;
	RayHandler ray;

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
		assetManager = new AssetManager(debugUtil);
		assetManager.InitManagers();
		debugRender = new Box2DDebugRenderer(true, false, false, false, false, false);
		// init the renderer that creates the camera and will eventually be used for all
		// basic
		// 2D rendering
		renderer = new Basic2DRenderer(assetManager, 1280, 720, debugUtil);

		// init the input handler for keyboard input
		input = new KeyboardInputHandler();

		// init a player object (currenly just used for testing)
		Gdx.input.setInputProcessor(input);

		player = new TestPlayer(assetManager.textureManager(), "Test", 100, assetManager.textureManager().playerSheet);
		playerMovement = new Player2DMovement(player, input, renderer.batch, assetManager.animationManager());
		
		// set the default input processor to the keyboard input manager - this needs to
		// be done or else
		// input from the input manager will not work


		
		renderer.playerMovement = playerMovement;
		player.createBody(renderer.world.world, BodyType.DynamicBody);
		renderer.player = player;
		ray = new RayHandler(renderer.world.world);
		ray.setAmbientLight(.3f);
		light = new PointLight(ray, 500, new Color(0.4f, 0.2f, 0.1f, 1f), 600, 200, -64);
		// light = new PointLight(ray, 500, new Color(0.4f, 0.2f, 0.1f,1f), 200, 600,
		// -64);

	}

	// this method isn't require but is called every render cycle to check for user
	// input and to see if anything
	// data wise has changed and if so it is modified

	/**
	 * This is required as it disposes of all things that were loaded into memory
	 * such as textures and sounds
	 */
	@Override
	public void dispose() {

		// This tells the sprite batch to dispose everything(such as the camera and
		// such)
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
		ray.setCombinedMatrix(renderer.getCamera());
		// This tells the sprite batch to begin another batch to render - all rendering
		// is done between this and .end();

		// this draws the player to the screen by obtaining the players texture from the
		// player object, getting the players current
		// at the current players x and y position
		// this ends the drawing of things to the screen
		debugRender.render(renderer.world.world, renderer.getCamera().combined);

		ray.updateAndRender();

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
	}
}
