/*Author: Hunter Barnard
 * 
 * The purpose of this class is to render everything in 2D space
 * This will be called on by the main class to render, and in turn will call the world renderer class
 * to render the world, and so on. This classes main purpose is to really manage rendering rather than actually
 * render
 * 
 * This class also creates an orhtographic camera for 2D rendering
 */

package com.dalphin.engine.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.dalphin.engine.debug.DebugUtil;
import com.dalphin.engine.managers.AssetManager;
import com.dalphin.engine.player.Player2D;
import com.dalphin.engine.player.Player2DMovement;
import com.dalphin.engine.util.RandomUtil;
import com.dalphin.engine.world.WorldDef;
import com.dalphin.engine.world.WorldGen;

public class Basic2DRenderer {

	// the default viewport width for camera
	private int DEFAULTVIEWPORTWIDTH = 1280;

	// default viewport height for camera
	private int DEFAULTVIEWPORTHEIGHT = 720;

	// Viewport width and height used for creating camera
	private int viewPortWidth;
	private int viewPortHeight;

	//public WorldGen world;

	// declare the camera
	private OrthographicCamera camera;

	// declare a spritebatch(currently it is the passed in sprite batch but will be
	// changed later)
	public SpriteBatch batch;
	private AssetManager assetManager;

	// declare the texture manager(passed in by the main class)

	// declare the random util for random numbers
	private RandomUtil randomUtil;

	private DebugUtil debugUtil;

	public Player2DMovement playerMovement;
	public Player2D player;
	float elapsedTime = 0;
	
	WorldDef worldDef;

	// create the basic 2d renderer from constructor that takes in a sprite batch
	// and a texture manager
	public Basic2DRenderer(AssetManager assetManager) {

		// sets the class batch to the passed in batch
		this.batch = new SpriteBatch();

		// sets the texture manager to the passed in manager
		this.assetManager = assetManager;

		// sets the cameras viewport width and height to default values as none are
		// provided
		this.viewPortWidth = DEFAULTVIEWPORTWIDTH;
		this.viewPortHeight = DEFAULTVIEWPORTHEIGHT;
		create();
	}

	// Create the basic 2d renderer by passing in a sprite batch, texture manager,
	// and a port width and height for the camera
	public Basic2DRenderer(AssetManager assetManager, int viewPortWidth, int viewPortHeight, DebugUtil debugUtil) {

		batch = new SpriteBatch();
		worldDef = new WorldDef(assetManager.blockManager());

		// set the local texture manager to the passed in texture manager
		this.assetManager = assetManager;
		this.debugUtil = debugUtil;
		// set the viewport for the camera to the passed in values
		this.viewPortWidth = viewPortWidth;
		this.viewPortHeight = viewPortHeight;

		create();
	}

	public void create() {
		// init the random util
		randomUtil = new RandomUtil();
		// create the camera using the passed in viewport values
		camera = new OrthographicCamera(viewPortWidth, viewPortHeight);
		batch.setProjectionMatrix(camera.combined);
		//world = new WorldGen(assetManager.blockManager(), debugUtil);
		//world.genorateWorld();
		worldDef.genWorld(debugUtil);		
	}

	// get the camera from this class
	public OrthographicCamera getCamera() {
		return this.camera;
	}

	public void update() {
		
	}

	// this method is what actually renders stuff to the screen, it will use other
	// rendering functions in other classes such as
	// the world renderer to render things to the screen
	public void render() {
		batch.setProjectionMatrix(camera.combined);
		elapsedTime += Gdx.graphics.getDeltaTime();
		camera.update();
		batch.begin();
		//world.drawWorld(batch, elapsedTime);
		worldDef.renderWorld(batch);
		playerMovement.update(Gdx.graphics.getDeltaTime());
		player.draw(batch, assetManager.animationManager(),elapsedTime);
		batch.end();
	}
}
